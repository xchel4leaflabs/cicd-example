import java.util.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

//val keystorePropertiesFile = rootProject.file("keystore.properties")
//val keystoreProperties = Properties()
//keystoreProperties.load(FileInputStream(keystorePropertiesFile))

android {
    namespace = "com.fourleaflabs.cicd"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.fourleaflabs.cicd"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    //signingConfigs {
    //    create("release") {
    //        storeFile = file(keystoreProperties["storeFile"] as String)
    //        storePassword = keystoreProperties["storePassword"] as String
    //        keyAlias = keystoreProperties["keyAlias"] as String
    //        keyPassword = keystoreProperties["keyPassword"] as String
    //    }
    //}

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            //signingConfig = signingConfigs.getByName("release")
        }
    }
    flavorDimensions += "default"
    productFlavors {
        create("flavorFirst") {
            resValue( "string", "app_name", "flavorFirst")
            applicationIdSuffix = ".flavor1"
        }
        create("flavorSecond") {
            resValue( "string", "app_name", "flavorSecond")
            applicationIdSuffix = ".flavor2"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}