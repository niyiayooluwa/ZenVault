plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.zenvault.intern"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.zenvault.intern"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.benchmark.macro)
    implementation(libs.androidx.runtime.livedata)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //Navigation
    // Views/Fragments Integration
    implementation ("androidx.navigation:navigation-fragment:2.8.5")
    implementation ("androidx.navigation:navigation-ui:2.8.5")

    // Feature module support for Fragments
    implementation ("androidx.navigation:navigation-dynamic-features-fragment:2.8.5")

    // Testing Navigation
    androidTestImplementation ("androidx.navigation:navigation-testing:2.8.5")

    // JSON serialization library, works with the Kotlin serialization plugin.
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

    // Jetpack Compose Integration
    implementation ("androidx.navigation:navigation-compose:2.8.5")

    //system UI controller
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.27.0")

    //Extended Icons
    implementation("androidx.compose.material:material-icons-extended:1.7.5")

    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.6.0")

}