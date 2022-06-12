plugins {
    id(BuildPlugins.javaLib)
    id(BuildPlugins.kotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(path = ":domain"))
}