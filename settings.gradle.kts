pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NYTimesArticles"
include(":app")
include(":core")
include(":design-system")
include(":features:nyarticles")
include(":utils")
include(":features:nyarticles:data")
include(":features:nyarticles:domain")
