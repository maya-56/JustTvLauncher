plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    /**
     * Personal opinion:
     * compileSdk doesn't make sense,
     * just generally be consistent with targetSdk.
     */
    compileSdk = 32
    defaultConfig {
        applicationId = "crazyboyfeng.justTvLauncher"
        minSdk = 17
        targetSdk = 32
        versionCode = 20240219
        versionName = "2024.2.19"
//        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
//    implementation("androidx.core:core-ktx:1.6.0")
//    implementation("androidx.appcompat:appcompat:1.3.1")
//    implementation("com.google.android.material:material:1.4.0")
//    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("androidx.leanback:leanback:1.0.0")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.3")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}