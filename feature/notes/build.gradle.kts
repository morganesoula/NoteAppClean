plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.msoula.noteappclean.feature.notes"
}

dependencies {
    // Core
    implementation(libs.runtime)
}