plugins {
    id(BuildPlugins.javaLib)
    id(BuildPlugins.kotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(Deps.Kotlin.coroutinesCore)
    testImplementation(Deps.junit)
    testImplementation(Deps.truth)
    testImplementation(Deps.mockk)
    testImplementation(Deps.Kotlin.coroutinesTest)
}