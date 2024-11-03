// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.23" apply false
    id("com.google.gms.google-services") version "4.4.1" apply false

    //Dagger hilt
    id("com.google.dagger.hilt.android") version "2.51" apply false

    //KPS:
    id("com.google.devtools.ksp") version "1.9.23-1.0.19" apply false

    kotlin("jvm") version "1.9.20"
    kotlin("plugin.serialization") version "1.9.20"
}