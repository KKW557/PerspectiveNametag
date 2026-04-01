pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven {
            name = "FabricMC"
            url = uri("https://maven.fabricmc.net/")
        }
        maven {
            name = "legacy-fabric"
            url = uri("https://maven.legacyfabric.net/")
        }
    }
}

include(
    "perspectivenametag-core",
    "perspectivenametag-fabric"
)
