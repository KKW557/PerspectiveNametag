pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven {
            name = "FabricMC"
            url = uri("https://maven.fabricmc.net/")
        }
    }
}

include(
    "perspectivenametag-core",
    "perspectivenametag-fabric"
)
