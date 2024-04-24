plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.msoula.noteappclean.feature.addnote"
}

dependencies {
    // Core
    implementation(libs.runtime)
}