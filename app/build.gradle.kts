plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.falcon.openinapp_assignment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.falcon.openinapp_assignment"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("com.google.android.gms:play-services-auth:20.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation ("com.google.accompanist:accompanist-pager:0.30.1")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.30.1")

    implementation ("com.airbnb.android:lottie-compose:6.0.0")
    implementation ("com.tom-roush:pdfbox-android:2.0.27.0")
    implementation ("com.google.android.gms:play-services-mlkit-text-recognition-common:19.0.0")

    val billingVersion = "6.0.1"

    implementation ("com.android.billingclient:billing:$billingVersion")
    implementation ("com.android.billingclient:billing-ktx:$billingVersion")



    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation ("com.squareup.okhttp3:okhttp:4.9.1")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation ("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    implementation ("io.coil-kt:coil-compose:2.2.2")

    implementation ("androidx.navigation:navigation-compose:2.6.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")


    implementation ("androidx.compose.material:material-icons-core:1.4.3")
    implementation ("androidx.compose.material:material-icons-extended:1.4.3")

    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    implementation ("com.google.android.gms:play-services-oss-licenses:17.0.1")

    implementation ("com.google.firebase:firebase-firestore-ktx:24.7.0")
    implementation ("com.google.firebase:firebase-auth-ktx:22.1.0")

    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
//    implementation ("com.itextpdf:itext7-core:8.0.2")
//    implementation ("com.itextpdf.android:kernel-android:8.0.1")
    implementation ("com.itextpdf:itextg:5.5.10") // Use the version appropriate for your project
    implementation ("com.madgag.spongycastle:prov:1.56.0.0") // Use the version appropriate for your project
    implementation("androidx.core:core-splashscreen:1.0.1")

}

kapt {
    correctErrorTypes = true
}