plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //Dagger hilt

    id("com.google.dagger.hilt.android")


    //kps:

    id("com.google.devtools.ksp") //version "1.9.23-1.0.19"

}
repositories {
    //mavenCentral() // o cualquier otro repositorio que necesites
   // google()
}

android {
    namespace = "com.solidtype.solidnotes"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.solidtype.solidnotes"
        minSdk = 29
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation(platform("androidx.compose:compose-bom:2024.10.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")


    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation("androidx.navigation:navigation-runtime-ktx:2.8.3")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.6")
    implementation("androidx.compose.animation:animation-android:1.7.4")
    implementation("androidx.compose.runtime:runtime-android:1.7.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-android:2.8.7")
    implementation("androidx.activity:activity-ktx:1.9.3")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.05.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")



    //Corrutinas
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")

    implementation ("androidx.navigation:navigation-compose:2.8.3")

    //LoginViewModel
    implementation ("androidx.compose.runtime:runtime-livedata:1.7.4")

    //Dagger hilt
    implementation("com.google.dagger:hilt-android:2.51")
    ksp("com.google.dagger:hilt-android-compiler:2.51")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    //KSP:
    implementation("com.google.devtools.ksp:symbol-processing-api:1.9.22-1.0.17") // Dependencia de KSP
    implementation("com.google.devtools.ksp:symbol-processing:1.9.22-1.0.17") // Dependencia de KSP

    //Room Database
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")

    ksp("androidx.room:room-compiler:$room_version")

    implementation("androidx.room:room-ktx:$room_version")

    //Matirial

    implementation ("androidx.compose.material:material")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material3:material3-android:1.2.1")
    implementation ("androidx.compose.material:material-icons-extended:1.7.4")
    implementation ("androidx.compose.material:material-icons-core:1.7.4")
}

ksp {
    // Configuración específica de KSP
   // arg("output", "$buildDir/generated/ksp")// Argumentos opcionales para KSP
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17" // La versión de JVM que estás utilizando
        //freeCompilerArgs += listOf("-Xlint:deprecation")
        //freeCompilerArgs += listOf("-opt-in=kotlin.RequiresOptIn") // Otras opciones de compilación
    }
}