plugins {
    java
}

repositories {
    maven { url = uri("https://libraries.minecraft.net/") }
    maven { url = uri("https://maven.neoforged.net/releases") }
}

dependencies {
    implementation(libs.fancymodloader.loader)
    implementation(project(":perspectivenametag-core"))
    implementation(project(":perspectivenametag-common"))
}

tasks.processResources {
    from(project(":perspectivenametag-common").sourceSets.main.get().resources)

    filteringCharset = "UTF-8"

    inputs.property("version", project.version)
    inputs.property("minecraft", libs.versions.minecraft.get())
    inputs.property("loader", libs.versions.neoforge.loaderVersion.get())

    filesMatching("META-INF/neoforge.mods.toml") {
        expand(
            "version" to version,
            "minecraft" to libs.versions.minecraft.get(),
            "loader" to libs.versions.neoforge.loaderVersion.get()
        )
    }
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    from(project(":perspectivenametag-core").sourceSets.main.get().output)
    from(project(":perspectivenametag-common").sourceSets.main.get().output)
}
