pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
        maven {
            url = uri("https://jitpack.io")
            url = uri("https://my.pspdfkit.com/maven/")
            url = uri("https://jcenter.bintray.com")
            url = uri("https://repo.itextsupport.com/android")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Open In App - Assignment"
include(":app")
 