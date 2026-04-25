plugins {
    alias(libs.plugins.fabric.loom)
}

dependencies {
    minecraft(libs.minecraft)
    implementation(libs.fabric.loader)
    implementation(project(":perspectivenametag-core"))
    implementation(project(":perspectivenametag-common"))
    include(project(":perspectivenametag-core"))
    include(project(":perspectivenametag-common"))
}

tasks.processResources {
    filteringCharset = "UTF-8"

    inputs.property("version", project.version)
    inputs.property("minecraft", libs.versions.minecraft.get())
    inputs.property("fabricloader", libs.versions.fabric.loader.get())

    filesMatching("fabric.mod.json") {
        expand(
            "version" to version,
            "minecraft" to libs.versions.minecraft.get(),
            "fabricloader" to libs.versions.fabric.loader.get()
        )
    }
}
