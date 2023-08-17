package com.shuwen.versionplugin

/**
 * 配置和build相关的
 */
object BuildVersion {
    const val compileSdkVersion = 33
    const val buildToolsVersion = "29.0.2"
    const val minSdkVersion = 21
    const val targetSdkVersion = 33
    const val versionCode = 1
    const val versionName = "1.0"
}

const val koin_version= "3.3.2"
const val koin_android_version= "3.3.2"
const val koin_android_compose_version= "3.4.1"

/**
 * 项目相关配置
 */
object BuildConfig {
    //AndroidX
    const val appcompat = "androidx.appcompat:appcompat:1.5.1"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    const val core_ktx = "androidx.core:core-ktx:1.9.0"
    const val material = "com.google.android.material:material:1.7.0"
    const val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
    const val recyclerview = "androidx.recyclerview:recyclerview:1.1.0"
    const val cardview = "androidx.cardview:cardview:1.0.0"
    const val databinding = "androidx.databinding:databinding-runtime:7.3.1"
    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:2.5.3"
    const val navigation_ktx = "androidx.navigation:navigation-ui-ktx:2.5.3"
    const val junittest = "androidx.test.ext:junit:1.1.4"

    // oKHttp
    const val okhttp3 = "com.squareup.okhttp3:okhttp:4.9.0"
    const val okhttp3_log = "com.squareup.okhttp3:logging-interceptor:4.9.0"
    // retrofit
    const val retrofit2 = "com.squareup.retrofit2:retrofit:2.9.0"
    const val gson = "com.squareup.retrofit2:converter-gson:2.9.0"

    //Depend
    const val junit = "junit:junit:4.13.2"
    const val espresso_core = "androidx.test.espresso:espresso-core:3.5.0"
    const val guava = "com.google.guava:guava:24.1-jre"
    const val commons = "org.apache.commons:commons-lang3:3.6"
    const val zxing = "com.google.zxing:core:3.3.2"

    //leakcanary
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:2.4"

    //jetPack
    const val room_runtime = "androidx.room:room-runtime:2.2.5"
    const val room_compiler = "androidx.room:room-compiler:2.2.5"
    const val room_rxjava2 = "androidx.room:room-rxjava2:2.2.5"
    const val lifecycle_extensions = "android.arch.lifecycle:extensions:1.1.1"
    const val lifecycle_compiler = "android.arch.lifecycle:compiler:1.1.1"
    const val rxlifecycle = "com.trello.rxlifecycle3:rxlifecycle:3.1.0"
    const val rxlifecycle_components = "com.trello.rxlifecycle3:rxlifecycle-components:3.1.0"

    //Kotlin
    const val kotlinx_coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7"

    // Koin for Kotlin
    const val koin_core = "io.insert-koin:koin-core:$koin_version"

    // Koin for Android
    const val koin_android = "io.insert-koin:koin-android:$koin_android_version"

    // Koin for jetPack
    const val koin_jetpack = "io.insert-koin:koin-androidx-compose:$koin_android_compose_version"

    // Glide
    const val glide = "com.github.bumptech.glide:glide:4.14.2"
    const val glide_compiler = "com.github.bumptech.glide:compiler:4.14.2"

    // SwipeRefresh
    const val swipe_refresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

    // livedata
    const val livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:2.5.1"

    // viewModel
    const val viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"

    // youthBanner
    const val youth_banner = "io.github.youth5201314:banner:2.2.2"

    const val timber = "com.jakewharton.timber:timber:5.0.1"
}