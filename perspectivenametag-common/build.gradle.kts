plugins {
    alias(libs.plugins.fabric.loom)
}

repositories {
    maven("https://repo.spongepowered.org/maven/")
}

dependencies {
    minecraft(libs.minecraft)
    mappings(loom.officialMojangMappings())
    implementation(libs.mixin)
    implementation(project(":perspectivenametag-core"))
}