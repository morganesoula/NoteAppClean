plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id(Plugins.DAGGER_HILT)
    kotlin(Plugins.KAPT)
}

android {
    namespace = "com.msoula.noteappclean"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.msoula.noteappclean"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // AndroidX
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.lifecycle.runtime.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.kotlinx.collections.immutable)

    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.material3)
    implementation(libs.androidx.ui.tooling)

    // Core
    implementation(libs.core.ktx)
    implementation(libs.runtime)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Modules
    implementation(project(Modules.DATABASE))
    implementation(project(Modules.DAO))
    implementation(project(Modules.DI))
    implementation(project(Modules.ADD_NOTE_PRESENTATION))
    implementation(project(Modules.NOTE_DATA))
    implementation(project(Modules.NOTE_DOMAIN))
    implementation(project(Modules.NOTE_PRESENTATION))
    implementation(project(Modules.NOTE_DETAIL_PRESENTATION))

    // Navigation
    implementation(libs.navigation.ui.ktx)
    implementation(libs.androidx.hilt.navigation.compose)
}