class Dependencies {
}

object BuildPlugins {
    val androidApp by lazy { "com.android.application" }
    val androidLib by lazy { "com.android.library" }
    val kotlin by lazy { "org.jetbrains.kotlin.android" }
    val kotlinJvm by lazy { "org.jetbrains.kotlin.jvm" }
}

object Deps {
    object AndroidX {
        val coreKtx by lazy { "androidx.core:core-ktx:${Versions.androidXCore}" }
        val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}" }
        val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }

        object Test {
            val junit by lazy { "androidx.test.ext:junit:1.1.3" }
            val espresso by lazy { "androidx.test.espresso:espresso-core:3.4.0" }
            val uiJunit by lazy { "androidx.compose.ui:ui-test-junit4:1.2.0-beta03" }
        }
    }

    object Compose {
        val ui by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
        val material3 by lazy { "androidx.compose.material3:material3:${Versions.composeMaterial3}" }
        val uiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}" }
        val uiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.compose}" }
        val uiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest:${Versions.compose}" }

    }


    val junit by lazy { "junit:junit:4.13.2" }
}