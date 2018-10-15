@Library(['com.adobe.qe.evergreen.sprout@prerelease'])
@Library(['com.adobe.qe.evergreen.forms.sprout@master'])

import com.adobe.qe.evergreen.sprout.*
import com.adobe.qe.evergreen.sprout.criteria.*
import com.adobe.qe.evergreen.sprout.model.*
import com.adobe.qe.evergreen.sprout.Pipeline
import com.adobe.qe.evergreen.sprout.SproutConfig
import com.adobe.qe.evergreen.sprout.model.IntegrationTestRun
import com.adobe.qe.evergreen.sprout.command.IntegrationTestRunCommand
import com.adobe.qe.evergreen.sprout.model.MavenDependency
import com.adobe.qe.evergreen.sprout.model.UITestRun
import com.adobe.qe.evergreen.sprout.model.Module
import com.adobe.qe.evergreen.sprout.strategy.EmptyStrategy
import com.adobe.qe.evergreen.sprout.vcs.RepositoryConfig
import com.adobe.qe.evergreen.sprout.vcs.clonecommand.*

import com.adobe.qe.evergreen.forms.sprout.strategy.CQDockerEnvironmentStrategy
import com.adobe.qe.evergreen.forms.sprout.model.FormsDockerInstance
import com.adobe.qe.evergreen.forms.sprout.config.FormsGitHubMergePRConfig
/* ========================================================================
                                CONSTANTS
======================================================================== */
//the slave machines need to have java at the location
def JAVA_PATH = "/opt/jdk1.8.0_131"

//this is the label of slaves, use 'centos' for maximum optimization
def NODE_LABEL = "centos"

//PARAMS FOR UI TESTS - Hobbes
//=============================
//minion hub URL based out of Noida
//def MINION_HUB_URL = "http://no1010042153089.corp.adobe.com:8811"

//browser on which the test cases are to be run
//def UITESTS_BROWSER = "CHROME"

/* ========================================================================
                           REPOSITORIES
======================================================================== */
        RepositoryConfig formsSmokeITRepo = new RepositoryConfig('git@git.corp.adobe.com:livecycle/forms-smoke-it.git')
                .withDefaultBranch('master')
                .withFolder('smoke-it')
                .withVCS('git')
                .build()

/* ========================================================================
                           CUSTOM STRATEGY
======================================================================== */
//emptyStrategy is required to disable CQBuild strategy as we do not want to build CQ - as we use existing docker image for it
EmptyStrategy emptyStrategy = new EmptyStrategy()

//dockerStrategy uses docker images instead of building CQ locally
//dockerStrategy API supports providing credentials for downloading the image (by default docker with latest CQ and AEMFD is downloaded/started)
CQDockerEnvironmentStrategy dockerStrategy = new CQDockerEnvironmentStrategy()

//PRMerge strategy for AEM forms which does additional validation - for details refer to wiki
FormsGitHubMergePRConfig formsMergePRConfig = new FormsGitHubMergePRConfig()

/* ========================================================================
                           MODULE CONFIGURATION
======================================================================== */
//define this to run the maven build command 'mvn clean install -DskipTests', and all the artifacts matching the patterns below
//would be installed on the docker image before running the test cases
//'main' - this is the default location of syncing the main repo code, and this folder is used for running the maven command
Module mainModule = new Module.Builder('main')
  .withArtifact("packages1", 'main/package_aem/target/*.zip', true)
  .build()

//smoke IT test cases need to be run for all the components, retain the below section
//smoke IT test code is synced to smoke-it folder, see 'setRepositories' call below
Module smokeITTests = new Module.Builder('smoke-it/basic')
    .withArtifact("smoke-it-tests-jar", 'smoke-it/basic/target/*.jar')
    .build()
	
//Module to update the forms.version in provisioning file
Module formsMFProvisModule  = new Module.Builder('main/mf-commons')
    .withArtifact("bundles",'main/mf-commons/target/*.jar',true)
    .withProvisioningModelRewriterPattern("cq-adaptiveforms-model.txt")
    .build()	

//Module to update the forms.version in provisioning file
Module formsclientProvisModule  = new Module.Builder('main/client')
    .withArtifact("bundles",'main/client/target/*.zip',true)
    .withProvisioningModelRewriterPattern("cq-adaptiveforms-model.txt")
    .build()
	
//Any additional bundles/packages that need to be installed on the CQ instance before running the test cases
//AF requires junit core bundle and MF test bundle and packages seen below
MavenDependency itJunitCore = new MavenDependency.Builder()
    .withGroupId("org.apache.sling")
    .withArtifactId("org.apache.sling.junit.core")
    .withVersion("1.0.26")
    .withExtension("jar")
    .build()


//Capture all the modules than need to be build as part of the build process
List<Module> modules = [mainModule, smokeITTests, formsMFProvisModule, formsclientProvisModule]

/* ========================================================================
                      QUICKSTART SERVER FOR SMOKE TESTS
======================================================================== */

Quickstart formsQuickstart = new BuildQuickstart.Builder('Forms Quickstart')
    .withModules(modules)
    .build()
    
/* ========================================================================
                      FORMS DOCKER CONFIGURATION
======================================================================== */
//All the maven dependency need to be added here as part of the docker configuration to install the same as part of instance creation
FormsDockerInstance author = new FormsDockerInstance.Builder()
    .withMavenDependency(itJunitCore)
    .build()


/* ========================================================================
                           TEST CONFIGURATION
======================================================================== */
//Define the test cases that need to be run
//Smoke IT test cases need to be run for all the components, copy the section below in your component Jenkinsfile
IntegrationTestRun smokeIT = new IntegrationTestRun.Builder()
    .withName('Smoke IT Tests')
    .withBundle('smoke-it/basic')
    .withNodeLabel(NODE_LABEL)
    .withInstance(author)
	.withTestCommand(new IntegrationTestRunCommand() {
		@Override
		void execute() {
			this.getJenkins().sh("mvn install -Dtest=*")
		}}
		
	)
    .withTestResultPattern('**/target/surefire-reports/*.xml')
    .build()

// ***** QUICKSTART SMOKE TESTS

EvergreenTestRun evergreenSmoke = new EvergreenTestRun.Builder()
   .withName('Smoke Tests')
   .withGroup('SMOKE')
   .withQuickstart(formsQuickstart)
   .withNodeLabel(NODE_LABEL)
   .withAdditionalParam("-Dskip.otherCqRunningCheck=true")
   .build()
	
/* ========================================================================
                     FINALLY THE SPROUT CONFIGURATION
======================================================================== */
SproutConfig config = new SproutConfig()
config.setModules(modules) //modules to be built
config.setTestRuns([evergreenSmoke, smokeIT]) //test cases to be run
config.setJavaVersion(JAVA_PATH) //setting the java path
config.setGeneralNodeLabel(NODE_LABEL) //jenkins slave label for main build (use same - suggested 'centos')
config.setComputeCoverage(false) //code coverage currently not supported - need to disable for now
//List of additional repositories to be sync'ed (apart from the main repository containing the Jenkinsfile)
config.setRepositories([ formsSmokeITRepo ])
//enable notification
config.setEnableMailNotification(true)
config.setMailNotificationRecipients(['mayagraw@adobe.com','aakhan@adobe.com','deepakk@adobe.com'])
config.setMailNotifyEveryUnstableBuild(true)

//The pull request are currently not auto-merged, but enable below option to support emails
config.setGithubMergePR(formsMergePRConfig)
config.getGithubMergePR().setEnablePRMerge(true)
//config.getGithubMergePR().setUsersWhitelist([])  //whitelist can be emptied (default everyone) to ensure no pull request is merged automatically, or provide a whitelist of users
//need to set this for now - use exact same string as CI server has a token configured with this name (user: cq-guides)
config.setGithubAccessTokenId("cq-guides-password")
config.getElasticsearchReporting().setCredentialsId('cq-guides-password')
config.setTimeoutMinutes(180)

//execute the pipeline with the configuration defined above
Pipeline sprout = new Sprout.Builder()
        .withConfig(config)
        .withJenkins(this)
        .withBuildCQStrategy(emptyStrategy)
        .withCQEnvironmentStrategy(dockerStrategy)
        .build()

sprout.execute()
