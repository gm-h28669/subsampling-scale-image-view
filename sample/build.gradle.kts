import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
}

android {
    compileSdk = 36

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        minSdk = 24
        applicationId = "com.davemorrissey.labs.subscaleview.test"
        versionCode = 4
        versionName = "3.1.0"
    }

    sourceSets {
        getByName("main") {
            assets.setSrcDirs(listOf("assets"))
            java.setSrcDirs(listOf("src/main/kotlin"))
        }
    }
    namespace = "com.davemorrissey.labs.subscaleview.test"
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    implementation(project(":library"))
    implementation(libs.kotlin.stdlib)
    api(libs.androidx.appcompat)
}
