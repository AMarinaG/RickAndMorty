import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask

plugins {
    id(BuildPlugins.androidApp)
    id(BuildPlugins.kotlin)
    id(BuildPlugins.detekt)
    id(BuildPlugins.kapt)
    id(BuildPlugins.hilt)
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.amarinag.rickandmorty"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "0.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0-beta01"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    testOptions {
        reportDir = "$rootDir/test-reports"
        resultsDir = "$rootDir/test-results"
//        unitTests.setReturnDefaultValues(true)
    }
}

detekt {
    buildUponDefaultConfig = true
    allRules = false
    config = files("$rootDir/config/detekt.yml")
    baseline = file("$rootDir/config/baseline.xml")
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = "1.8"
}
tasks.withType<DetektCreateBaselineTask>().configureEach {
    jvmTarget = "1.8"
}

dependencies {
    implementation(project(path = ":domain"))
    implementation(Deps.AndroidX.coreKtx)
    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.navigation)
    implementation(Deps.Compose.material3)
    implementation(Deps.Compose.material3WindowSize)
    implementation(Deps.Compose.uiToolingPreview)
    implementation(Deps.AndroidX.lifecycleRuntime)
    implementation(Deps.AndroidX.activityCompose)
    implementation(Deps.Hilt.android)
    kapt(Deps.Hilt.compiler)
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.AndroidX.Test.junit)
    androidTestImplementation(Deps.AndroidX.Test.espresso)
    androidTestImplementation(Deps.AndroidX.Test.uiJunit)
    debugImplementation(Deps.Compose.uiTooling)
    debugImplementation(Deps.Compose.uiTestManifest)
}