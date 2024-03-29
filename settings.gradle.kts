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
include(":mod5activites")
include(":mod5unittest")
include(":mod5nav")
include(":mod6sqlite")
include(":mod6datastore")
include(":mod6room")
include(":mod7retrofit")
include(":mod8workmanager")
include(":mod2callbac")
