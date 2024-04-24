plugins {
    `android-library`
    `kotlin-android`
    kotlin(Plugins.KAPT)
}

apply<MainGradlePlugin>()

android {
    namespace = "com.msoula.noteappclean.core.database.dao"
}

dependencies {
    // Core
    implementation(libs.runtime)

    // Room
    api(libs.room.runtime)
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)
}