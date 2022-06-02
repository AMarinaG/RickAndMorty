buildscript {

}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(BuildPlugins.androidApp) version Versions.agp.toString() apply false
    id(BuildPlugins.androidLib) version Versions.agp.toString() apply false
    id(BuildPlugins.kotlin) version Versions.kotlin.toString() apply false
}

tasks.create("clean", Delete::class) {
    delete(rootProject.buildDir)
}