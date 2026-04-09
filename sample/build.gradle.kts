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
        targetSdk = 35
        applicationId = "com.davemorrissey.labs.subscaleview.test"
        versionCode = 1
        versionName = "1.0.0"
    }

    sourceSets {
        getByName("main") {
            assets.directories.add("assets")
            java.directories.add("src/main/kotlin")
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
