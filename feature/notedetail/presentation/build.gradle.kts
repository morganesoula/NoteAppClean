plugins {
    `android-library`
    `kotlin-android`
    id(Plugins.DAGGER_HILT)
    kotlin(Plugins.KAPT)
}

apply<MainGradlePlugin>()

android {
    namespace = "com.msoula.noteappclean.feature.notedetail.presentation"
}

dependencies {
    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.material3)
    implementation(libs.androidx.ui.tooling)

    // Core
    implementation(libs.runtime)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Modules
    implementation(project(Modules.COMMON))
    implementation(project(Modules.DI))
    implementation(project(Modules.NOTE_DOMAIN))
}