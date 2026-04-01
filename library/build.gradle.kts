import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    `maven-publish`
}

android {
    compileSdk = 36
    namespace = "com.davemorrissey.labs.subscaleview"

    defaultConfig {
        minSdk = 24
        consumerProguardFiles("proguard-rules.txt")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/kotlin")
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.txt")
        }
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
        singleVariant("debug") {
            withSourcesJar()
        }
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "org.fossify"
                artifactId = "subsampling-scale-image-view"
                version = "3.2.0"
            }
            create<MavenPublication>("debug") {
                from(components["debug"])
                groupId = "org.fossify"
                artifactId = "subsampling-scale-image-view-debug"
                version = "3.2.0"
            }
        }
        repositories {
            maven {
                name = "local"
                url = uri(layout.buildDirectory.dir("localMaven"))
            }
        }
    }
}

dependencies {
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.exifinterface)
    implementation(libs.kotlin.stdlib)
}

tasks.named("build") {
    finalizedBy("publishToMavenLocal")
}
