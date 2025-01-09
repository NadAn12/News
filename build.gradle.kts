buildscript {
    dependencies {
        // Compose UI
        classpath(libs.compose.compiler.gradle.plugin)
        classpath (libs.kotlin.gradle.plugin)
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.54")
        repositories {
            mavenCentral()

        }
    }
}
plugins {
    id ("com.android.application") version "8.7.3" apply false
    id ("com.android.library") version "8.7.3" apply false
    id ("org.jetbrains.kotlin.android") version "2.0.0" apply false
    id ("com.google.dagger.hilt.android") version "2.54" apply false
    id ("org.jetbrains.kotlin.plugin.serialization") version "2.0.20"
    alias(libs.plugins.compose.compiler) apply false
    id ("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
}