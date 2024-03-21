pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Demonstrations"
include(":app")
include(":mod2variables")
include(":mod2conditions")
include(":mod2boucles")
include(":mod2fonctions")
include(":mod2structureclasse")
include(":mod2heritageinterface")
include(":mod3uixml")
include(":mod3compose")
include(":mod3lazycolumn")
include(":mod4gestioninteraction")
include(":mod4stateflowvm")
