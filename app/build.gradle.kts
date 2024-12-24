plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.news"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.news"
        minSdk = 26
        targetSdk = 34
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation (libs.kotlin.bom)
    implementation (libs.androidx.lifecycle.runtime.ktx)
    implementation (libs.androidx.activity.compose)
    implementation (libs.androidx.compose.bom)
    implementation (libs.androidx.ui)
    implementation (libs.androidx.ui.graphics)
    implementation (libs.androidx.ui.tooling.preview)
    implementation (libs.androidx.material3)
    testImplementation (libs.junit)
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation (libs.androidx.espresso.core.v351)
    androidTestImplementation (platform('androidx.compose:compose-bom:2022.10.00'))
    androidTestImplementation ('androidx.compose.ui:ui-test-junit4')
    debugImplementation 'androidx.compose.ui:ui-tooling'
    debugImplementation 'androidx.compose.ui:ui-test-manifest'

    //Splash Api
    implementation ("androidx.core:core-splashscreen:1.0.1")

    //Compose Navigation
    implementation ("androidx.navigation:navigation-compose:2.6.0")

    //Dagger Hilt
    implementation ("com.google.dagger:hilt-android:2.45")
    kapt ("com.google.dagger:hilt-compiler:2.45")
    implementation ('androidx.hilt:hilt-navigation-compose:1.0.0')


    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ('com.squareup.retrofit2:converter-gson:2.9.0')

    //Coil
    implementation ("io.coil-kt:coil-compose:2.4.0")

    //Datastore
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    //Compose Foundation
    implementation "androidx.compose.foundation:foundation:1.4.3"

    //Accompanist
    implementation "com.google.accompanist:accompanist-systemuicontroller:0.31.4-beta"

    //Paging 3
    def paging_version = "3.1.1"
    implementation "androidx.paging:paging-runtime:$paging_version"
    implementation "androidx.paging:paging-compose:3.2.0-rc01"

    //Room
    def room_version = "2.5.2"
    implementation "androidx.room:room-runtime:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
    implementation "androidx.room:room-ktx:2.5.2"
}