plugins {
    alias(libs.plugins.fabric.loom)
}

dependencies {
    minecraft(libs.minecraft)
    implementation(libs.fabric.loader)
    implementation(project(":perspectivenametag-core"))
    implementation(project(":perspectivenametag-common"))
}

loom {
    sourceSets {
        main {
            java {
                srcDir(project(":perspectivenametag-core").sourceSets.main.get().java.srcDirs)
                srcDir(project(":perspectivenametag-common").sourceSets.main.get().java.srcDirs)
            }
            resources {
                srcDir(project(":perspectivenametag-common").sourceSets.main.get().resources.srcDirs)
            }
        }
    }
}

tasks.processResources {
    filteringCharset = "UTF-8"

    inputs.property("version", project.version)
    inputs.property("minecraft", libs.versions.minecraft.get())
    inputs.property("loader", libs.versions.fabric.loader.get())

    filesMatching("fabric.mod.json") {
        expand(
            "version" to version,
            "minecraft" to libs.versions.minecraft.get(),
            "loader" to libs.versions.fabric.loader.get()
        )
    }
}
