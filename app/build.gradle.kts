plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
}

android {
    namespace = "it.cron.githubusers"
    compileSdk = 34

    defaultConfig {
        applicationId = "it.cron.githubusers"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures{
        viewBinding = true
    }

}

dependencies {



    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    implementation (libs.coil)

    //фрагмент
    implementation(libs.androidx.fragment.ktx)

    //даггер
    implementation(libs.dagger)
    implementation (libs.dagger.android)
    implementation (libs.dagger.android.support)
    kapt(libs.dagger.compiler)
    kapt (libs.dagger.android.processor)

    //свайп для обновления
    implementation(libs.androidx.swiperefreshlayout)

    //пагинация
    implementation(libs.androidx.paging.runtime)


    //ретрофит и моши
    implementation(libs.retrofit)
    implementation(libs.gson)
    implementation(libs.converter.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.converter.gson)





}