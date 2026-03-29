plugins {
    java
}

repositories {
    maven { url = uri("https://libraries.minecraft.net/") }
    maven { url = uri("https://files.minecraftforge.net/maven") }
}

dependencies {
    implementation(libs.fmlloader)
    implementation(libs.javafmllanguage)
    implementation(project(":perspectivenametag-core"))
    implementation(project(":perspectivenametag-common"))
}

tasks.processResources {
    from(project(":perspectivenametag-common").sourceSets.main.get().resources)

    filteringCharset = "UTF-8"

    inputs.property("version", project.version)
    inputs.property("minecraft", libs.versions.minecraft.get())
    inputs.property("loader", libs.versions.forge.loader.get())

    filesMatching("META-INF/mods.toml") {
        expand(
            "version" to version,
            "minecraft" to libs.versions.minecraft.get(),
            "loader" to libs.versions.forge.loader.get()
        )
    }
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    from(project(":perspectivenametag-core").sourceSets.main.get().output)
    from(project(":perspectivenametag-common").sourceSets.main.get().output)

    manifest {
        attributes(
            "MixinConfigs" to "perspectivenametag.mixins.json"
        )
    }
}
