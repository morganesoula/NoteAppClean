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

rootProject.name = "NoteAppClean"
include(":app")
include(":core")
include(":core:database")
include(":feature")
include(":feature:notes")
include(":feature:notes:data")
include(":feature:notes:domain")
include(":feature:notes:presentation")
include(":core:database:dao")
include(":core:di")
include(":feature:addnote")
include(":feature:addnote:presentation")
include(":feature:addnote:domain")
include(":core:common")
include(":feature:notedetail")
include(":feature:notedetail:presentation")
