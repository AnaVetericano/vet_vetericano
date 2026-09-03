plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.vet_vetericano"
    compileSdk {
        version = release(37) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.vet_vetericano"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    implementation("com.google.android.gms:play-services-location:21.1.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("com.google.android.material:material:1.11.0")
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0") //

}
