@Library(['com.adobe.qe.evergreen.sprout@prerelease'])
@Library(['com.adobe.qe.evergreen.forms.sprout@master'])

import com.adobe.qe.evergreen.sprout.*
import com.adobe.qe.evergreen.sprout.criteria.*
import com.adobe.qe.evergreen.sprout.model.*
import com.adobe.qe.evergreen.sprout.Sprout
import com.adobe.qe.evergreen.sprout.Pipeline
import com.adobe.qe.evergreen.sprout.SproutConfig
import com.adobe.qe.evergreen.sprout.model.IntegrationTestRun
import com.adobe.qe.evergreen.sprout.command.IntegrationTestRunCommand
import com.adobe.qe.evergreen.sprout.model.MavenDependency
import com.adobe.qe.evergreen.sprout.model.UITestRun
import com.adobe.qe.evergreen.sprout.model.Module
import com.adobe.qe.evergreen.sprout.strategy.EmptyStrategy
import com.adobe.qe.evergreen.sprout.command.*
import com.adobe.qe.evergreen.sprout.vcs.RepositoryConfig
import com.adobe.qe.evergreen.sprout.vcs.clonecommand.*	

import com.adobe.qe.evergreen.forms.sprout.strategy.CQDockerEnvironmentStrategy
import com.adobe.qe.evergreen.forms.sprout.strategy.StartDockerEnvironmentStrategy
import com.adobe.qe.evergreen.forms.sprout.strategy.BuildDockerStrategy
import com.adobe.qe.evergreen.forms.sprout.strategy.PostBuildStrategy
import com.adobe.qe.evergreen.forms.sprout.model.FormsDockerInstance
import com.adobe.qe.evergreen.forms.sprout.config.FormsGitHubMergePRConfig
import com.adobe.qe.evergreen.forms.sprout.command.MvnLinuxCommand

	
/* ========================================================================
                                CONSTANTS
======================================================================== */
//the slave machines need to have java at the location
def JAVA_PATH = "/opt/jdk1.8.0_131"

//this is the label of slaves, use 'centos' for maximum optimization
def NODE_LABEL = "aemds_master"

/* ========================================================================
                           REPOSITORIES
======================================================================== */
        RepositoryConfig formsSmokeITRepo = new RepositoryConfig('git@git.corp.adobe.com:livecycle/forms-smoke-it.git')
                .withDefaultBranch('master')
                .withFolder('smoke-it')
                .withVCS('git')
                .build()

        RepositoryConfig formsScenarioTestRepo = new RepositoryConfig('git@git.corp.adobe.com:livecycle/forms-scenariotests.git')
                .withDefaultBranch('master')
                .withFolder('forms-scenariotests')
                .withVCS('git')
                .build()

        RepositoryConfig formsRepo = new RepositoryConfig('git@git.corp.adobe.com:livecycle/forms.git')
                .withDefaultBranch('master')
                .withFolder('forms')
                .withVCS('git')
                .build()
				
        RepositoryConfig formsFoundationRepo = new RepositoryConfig('git@git.corp.adobe.com:livecycle/forms-foundation.git')
                .withDefaultBranch('master')
                .withFolder('forms-foundation')
                .withVCS('git')
                .build()				
				
        RepositoryConfig expEditorRepo = new RepositoryConfig('git@git.corp.adobe.com:livecycle/exp-editor.git')
                .withDefaultBranch('master')
                .withFolder('exp-editor')
                .withVCS('git')
                .build()

        RepositoryConfig formsManagerRepo = new RepositoryConfig('git@git.corp.adobe.com:livecycle/formsmanager.git')
                .withDefaultBranch('master')
                .withFolder('fm')
                .withVCS('git')
                .build()

        RepositoryConfig formsPortalRepo = new RepositoryConfig('git@git.corp.adobe.com:livecycle/formsportal.git')
                .withDefaultBranch('master')
                .withFolder('fp')
                .withVCS('git')
                .build()				
				
        RepositoryConfig guidesRepo = new RepositoryConfig('git@git.corp.adobe.com:livecycle/cq-guides.git')
                .withDefaultBranch('master')
                .withFolder('guides')
                .withVCS('git')
                .build()	

        RepositoryConfig multiChannelRepo = new RepositoryConfig('git@git.corp.adobe.com:livecycle/multi-channel-document.git')
                .withDefaultBranch('master')
                .withFolder('multi-channel')
                .withVCS('git')
                .build()

        RepositoryConfig fdCoreRepo = new RepositoryConfig('git@git.corp.adobe.com:livecycle/fd-channel-core.git')
                .withDefaultBranch('master')
                .withFolder('fd-channel')
                .withVCS('git')
                .build()				        

/* ========================================================================
                           CUSTOM STRATEGY
======================================================================== */
//newDockerStrategy is required to build docker for aemforms instead of CQ
BuildDockerStrategy newDockerStrategy = new BuildDockerStrategy()

//dockerStartStrategy start docker images instead of building CQ locally
StartDockerEnvironmentStrategy dockerStartStrategy = new StartDockerEnvironmentStrategy()

//postBuildStrategy is used to deploy aemfd package and docker on artifactory
PostBuildStrategy postBuildStrategy = new PostBuildStrategy()

//PRMerge strategy for AEM forms which does additional validation - for details refer to wiki
FormsGitHubMergePRConfig formsMergePRConfig = new FormsGitHubMergePRConfig()

//lnxCmd is used to build only Linux package for executing Smoke IT tests
SproutCommand lnxCmd = new MvnLinuxCommand()

/* ========================================================================
                           MODULE CONFIGURATION
======================================================================== */
//define this to run the maven build command 'mvn clean install -DskipTests', and all the artifacts matching the patterns below
//would be installed on the docker image before running the test cases
//'main' - this is the default location of syncing the main repo code, and this folder is used for running the maven command
Module mainModule = new Module.Builder('main')
  .withBuildCommand(lnxCmd)
  .withArtifact("packages", 'main/**/adobe-aemfd-linux-pkg*.zip', true)
  .withArtifact("tools", 'main/**/tools/*', true)
  .build()

//smoke IT test cases need to be run for all the components, retain the below section
//smoke IT test code is synced to smoke-it folder, see 'setRepositories' call below
Module smokeITTests = new Module.Builder('smoke-it/basic')
    .withArtifact("smoke-it-tests-jar", 'smoke-it/basic/target/*.jar')
    .build()
	
//Scenario Tests Collaterals
Module scenarioTestModule = new Module.Builder('forms-scenariotests')
    .withArtifact("scenario-jar", 'forms-scenariotests/**/testCollaterals/*.jar')
    .withArtifact("scenario-pkg",'forms-scenariotests/**/testCollaterals/*.zip')
    .build()
	
//Module to update the expeditor.version in provisioning file
Module rulebuilderProvisModule  = new Module.Builder('exp-editor/rule-builder')
    .withArtifact("ruleBuilder-pkg",'exp-editor/rule-builder/target/*.zip')
    .withProvisioningModelRewriterPattern("cq-adaptiveforms-model.txt")
    .build()	

//Module to update the formsportal.version in provisioning file
Module fpProvisModule  = new Module.Builder('fp/aempackage')
    .withArtifact("fp-pkg",'fp/aempackage/target/*.zip')
    .withProvisioningModelRewriterPattern("cq-adaptiveforms-model.txt")
    .build()
	
//Module to update the guides.version in provisioning file
Module guidesProvisModule  = new Module.Builder('guides/bundles/aemds-guide-core')
    .withArtifact("guides-jar",'guides/bundles/aemds-guide-core/target/*.jar')
	.withProvisioningModelRewriterPattern("cq-adaptiveforms-model.txt")
    .build()	
	
//Module to update the ccm.multichannel.version in provisioning file
Module multiChlProvisModule  = new Module.Builder('multi-channel/bundles/ccm-multi-channel-core')
    .withArtifact("multiChl-jar",'multi-channel/bundles/ccm-multi-channel-core/target/*.jar')
	.withProvisioningModelRewriterPattern("cq-adaptiveforms-model.txt")
    .build()	
	
//Module to update the fd.channel.version in provisioning file
Module fdChlProvisModule  = new Module.Builder('fd-channel/content')
    .withArtifact("fdChl-pkg",'fd-channel/content/target/*.zip')
	.withProvisioningModelRewriterPattern("cq-adaptiveforms-model.txt")
    .build()

//Need to remove this module once Fd-channel uber package issue resolves
Module fdChlAddonModule  = new Module.Builder('fd-channel/content')
    .withArtifact("fdChlAddon-pkg",'fd-channel/**/target/*.zip')
	.build()    		
	
//Module to update the fm.version in provisioning file
Module fmProvisModule  = new Module.Builder('fm/modules/formsmanagement/aemcorepackage')
    .withArtifact("fm-pkg",'fm/modules/formsmanagement/aemcorepackage/target/*.zip')
	.withProvisioningModelRewriterPattern("cq-adaptiveforms-model.txt")
    .build()	
	
	
//Module to update the forms.version in provisioning file
Module formsclientProvisModule  = new Module.Builder('forms/client')
    .withArtifact("forms-pkg",'forms/client/target/*.zip')
	.withProvisioningModelRewriterPattern("cq-adaptiveforms-model.txt")
    .build()	
	
//Module to update the formsfoundation.version in provisioning file
Module formsFoundationProvisModule  = new Module.Builder('forms-foundation/bundles/core')
    .withArtifact("ff-jar",'forms-foundation/bundles/core/target/*.jar')
	.withProvisioningModelRewriterPattern("cq-adaptiveforms-model.txt")
    .build()		
	
//Module to update the forms.version in provisioning file
Module formsMFProvisModule  = new Module.Builder('forms/mf-commons')
    .withArtifact("MF-jar",'forms/mf-commons/target/*.jar')
	.withProvisioningModelRewriterPattern("cq-adaptiveforms-model.txt")
    .build()

//Module to update the aemds.version in provisioning file
Module aemdsProvisModule  = new Module.Builder('main/aemforms-commons-content')
    .withArtifact("aemds-pkg",'main/aemforms-commons-content/target/*.zip')
	.withProvisioningModelRewriterPattern("cq-adaptiveforms-model.txt")
    .build()	
		

//Any additional bundles/packages that need to be installed on the CQ instance before running the test cases
//AF requires junit core bundle and MF test bundle and packages seen below
MavenDependency itJunitCore = new MavenDependency.Builder()
    .withGroupId("org.apache.sling")
    .withArtifactId("org.apache.sling.junit.core")
    .withVersion("1.0.23")
    .withExtension("jar")
    .build()


//Capture all the modules than need to be build as part of the build process
List<Module> modules = [mainModule, smokeITTests, scenarioTestModule, rulebuilderProvisModule, guidesProvisModule, multiChlProvisModule, fdChlProvisModule, fmProvisModule, formsclientProvisModule, formsFoundationProvisModule, aemdsProvisModule, fpProvisModule, fdChlAddonModule]

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
                 }
	    })
    .withTestResultPattern('**/target/surefire-reports/*.xml')
    .build()

//Scenario Tests execution
IntegrationTestRun scenarioTests = new IntegrationTestRun.Builder()
    .withName('Scenario Tests')
    .withBundle('forms-scenariotests')
    .withNodeLabel(NODE_LABEL)
    .withInstance(author)
    .withTestCommand(new IntegrationTestRunCommand() {
        @Override
            void execute() {
                    this.getJenkins().sh("mvn clean verify -Dtestng.groups=evergreen -DexecuteOnGrid=true -Dhub.hostname=10.42.128.162 -Dbrowser=chrome -DoverrideAuthor.hostname=true")
                 }
	    })
    .withTestResultPattern('**/target/failsafe-reports/*.xml')
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
config.setTestRuns([evergreenSmoke, smokeIT, scenarioTests]) //test cases to be run
config.setJavaVersion(JAVA_PATH) //setting the java path
config.setGeneralNodeLabel(NODE_LABEL) //jenkins slave label for main build (use same - suggested 'centos')

//List of additional repositories to be sync'ed (apart from the main repository containing the Jenkinsfile)
config.setRepositories([formsSmokeITRepo, formsScenarioTestRepo,formsRepo ,formsFoundationRepo, expEditorRepo, formsManagerRepo, formsPortalRepo, guidesRepo, multiChannelRepo, fdCoreRepo])

//enable notification
config.setEnableMailNotification(true)
config.setMailNotificationRecipients(['sonagupt@adobe.com','prgarg@adobe.com','mayankg@adobe.com','salilt@adobe.com','deepakk@adobe.com'])
config.setMailNotifyEveryUnstableBuild(false)

//enable elastic reporting
config.getElasticsearchReporting().setEnable(true)
config.getElasticsearchReporting().setCredentialsId('xfauser')

//The pull request are currently not auto-merged, but enable below option to support emails
config.setGithubMergePR(formsMergePRConfig)
config.getGithubMergePR().setEnablePRMerge(true)
//config.getGithubMergePR().setUsersWhitelist([])  //whitelist can be emptied (default everyone) to ensure no pull request is merged automatically, or provide a whitelist of users
//need to set this for now - use exact same string as CI server has a token configured with this name (user: cq-guides)
config.setGithubAccessTokenId("cq-guides-password")

config.setTimeoutMinutes(180)

//execute the pipeline with the configuration defined above
Pipeline sprout = new Sprout.Builder()
        .withConfig(config)
        .withJenkins(this)
        .withBuildCQStrategy(newDockerStrategy)
        .withCQEnvironmentStrategy(dockerStartStrategy)
	.withPostAcceptanceStrategy(postBuildStrategy)
        .build()

sprout.execute()