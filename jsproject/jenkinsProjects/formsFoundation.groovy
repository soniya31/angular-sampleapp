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
Module mainModule = new Module.Builder('main')
  .withArtifact("bundles", 'main/**/target/*.jar', true)
  .withArtifact("packages", 'main/**/target/*.zip', true)
  .build()

//smoke IT test cases need to be run for all the components, retain the below section
//smoke IT test code is synced to smoke-it folder, see 'setRepositories' call below

	Module smokeITTests = new Module.Builder('smoke-it/basic')
			.withArtifact("smoke-it-tests-jar", 'smoke-it/basic/target/*.jar')
			.build()
			
//Module to update the formsfoundation.version in provisioning file
Module formsFoundationProvisModule  = new Module.Builder('main/bundles/core')
    .withArtifact("bundles",'main/bundles/core/target/*.jar',true)
	.withProvisioningModelRewriterPattern("cq-adaptiveforms-model.txt")
    .build()			

	
//Any additional bundles/packages that need to be installed on the CQ instance before running the test cases
	MavenDependency itJunitCore = new MavenDependency.Builder()
					.withGroupId("org.apache.sling")
					.withArtifactId("org.apache.sling.junit.core")
					.withVersion("1.0.23")
					.withExtension("jar")
					.build()

	MavenDependency formsCompat = new MavenDependency.Builder()
					.withGroupId("com.adobe.aemds")
					.withArtifactId("adobe-aemfd-compat-pkg")
					.withVersion("LATEST")
					.withExtension("zip")
					.build()
					
	MavenDependency testContent = new MavenDependency.Builder()
					.withGroupId("com.adobe.aem.forms.testcontent")
					.withArtifactId("aem-forms-test-content")
					.withVersion("LATEST")
					.withExtension("zip")
					.build()
					

					
	MavenDependency aemUberCompat = new MavenDependency.Builder()
    					.withGroupId("com.adobe.cq")
    					.withArtifactId("aem-compat-cq64-to-cq63")
    					.withVersion("LATEST")
    					.withExtension("zip")
   					.build()
//Capture all the modules that need to be build as part of the build process

	List<Module> modules = [mainModule, smokeITTests, formsFoundationProvisModule]

/* ========================================================================
                      QUICKSTART SERVER FOR SMOKE TESTS
======================================================================== */

Quickstart formsQuickstart = new BuildQuickstart.Builder('Forms Quickstart')
    .withModule(formsFoundationProvisModule)
    .build()
    
/* ========================================================================
                      FORMS DOCKER CONFIGURATION
======================================================================== */
FormsDockerInstance author = new FormsDockerInstance.Builder()
    .withMavenDependency(itJunitCore)
    .build()

	FormsDockerInstance authorCompat = new FormsDockerInstance.Builder()
				.withMavenDependency(itJunitCore)
				.withMavenDependency(formsCompat)
				.withMavenDependency(testContent)
				.build()


/* ========================================================================
                           TEST CONFIGURATION
======================================================================== */
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

IntegrationTestRun devIT = new IntegrationTestRun.Builder()
    .withName('Dev IT Non-Compat Tests')
    .withBundle('main')
    .withNodeLabel(NODE_LABEL)
    .withInstance(author)
    .withTestCommand(new IntegrationTestRunCommand() {
                 @Override
                void execute() {
                                 this.getJenkins().sh("mvn clean verify -fae -Dfoundation.test.server.url=http://localhost:4502 -DskipCompat=true")
                                }
                })
    .withTestResultPattern('**/target/*eport*/**/*.xml')
    .build()
	
	IntegrationTestRun devITCompatTests = new IntegrationTestRun.Builder()
    .withName('Dev IT Compat Tests')
    .withBundle('main')
    .withNodeLabel(NODE_LABEL)
    .withInstance(authorCompat)
    .withTestCommand(new IntegrationTestRunCommand() {
                 @Override
                void execute() {
                                 this.getJenkins().sh("mvn clean verify -fae -Dfoundation.test.server.url=http://localhost:4502 -DskipCompat=false")
                                }
                })
    .withTestResultPattern('**/target/*eport*/**/*.xml')
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
config.setModules(modules)
config.setTestRuns([evergreenSmokesmokeIT, devIT,devITCompatTests]) 
config.setJavaVersion(JAVA_PATH)
config.setGeneralNodeLabel(NODE_LABEL)
config.setComputeCoverage(false)
config.setRepositories([ formsSmokeITRepo ])
config.setEnableMailNotification(true)
config.setMailNotificationRecipients(['CM@adobe.com'])
config.setMailNotifyEveryUnstableBuild(true)
config.getGithubMergePR().setEnablePRMerge(false)
config.setGithubAccessTokenId("cq-guides-password")
config.getElasticsearchReporting().setCredentialsId('cq-guides-password')
config.setTimeoutMinutes(180)

Pipeline sprout = new Sprout.Builder()
        .withConfig(config)
        .withJenkins(this)
        .withBuildCQStrategy(emptyStrategy)
        .withCQEnvironmentStrategy(dockerStrategy)
        .build()

sprout.execute()
