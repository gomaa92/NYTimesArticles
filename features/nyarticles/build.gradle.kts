plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.gomaa.nyarticles"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    android.buildFeatures.buildConfig = true
    buildTypes {
        debug {
            isMinifyEnabled = false
            buildConfigField("String", "API_KEY", "\"QlYGyjXK7GDLlarIFTAHXSjAocG0nmML\"")
        }
        release {
            isMinifyEnabled = false
            buildConfigField("String", "API_KEY", "\"QlYGyjXK7GDLlarIFTAHXSjAocG0nmML\"")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":design-system"))
    implementation(project(":utils"))
    implementation(project(":features:nyarticles:data"))
    implementation(project(":features:nyarticles:domain"))
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.compose.material3:material3")

    // Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")

    implementation("com.google.code.gson:gson:2.11.0")
    implementation("com.jakewharton.timber:timber:5.0.1")

    implementation("com.google.dagger:hilt-android:2.49")
    implementation("androidx.compose.ui:ui-test-junit4-android:1.6.7")
    kapt("com.google.dagger:hilt-compiler:2.48.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    implementation("io.coil-kt:coil-compose:2.6.0")
    implementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
    implementation("org.mockito:mockito-core:4.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")
}