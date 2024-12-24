// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    dependencies {
        // Compose UI
        classpath(libs.compose.compiler.gradle.plugin)
        classpath (libs.kotlin.gradle.plugin)
        repositories {
            mavenCentral()

        }
    }
}
plugins {
    id ("com.android.application") version "8.7.3" apply false
    id ("com.android.library") version "8.7.3" apply false
    id ("org.jetbrains.kotlin.android") version "1.7.20" apply false
    id ("com.google.dagger.hilt.android") version "2.44" apply false
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.8.21"
    alias(libs.plugins.compose.compiler) apply false
}