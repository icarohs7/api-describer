@file:Suppress("PublicApiImplicitType", "MemberVisibilityCanBePrivate", "unused")

object Deps {
    const val arrowCore = "io.arrow-kt:arrow-core:${Versions.arrow}"
    const val arrowData = "io.arrow-kt:arrow-data:${Versions.arrow}"
    const val arrowEffects = "io.arrow-kt:arrow-effects-kotlinx-coroutines:${Versions.arrow}"
    const val arrowInstancesData = "io.arrow-kt:arrow-instances-data:${Versions.arrow}"
    const val arrowQueryLanguage = "io.arrow-kt:arrow-query-language:${Versions.arrow}"
    const val arrowSyntax = "io.arrow-kt:arrow-syntax:${Versions.arrow}"
    const val arrowTypeclasses = "io.arrow-kt:arrow-typeclasses:${Versions.arrow}"
    const val coroutinesJavaFx = "org.jetbrains.kotlinx:kotlinx-coroutines-javafx:${Versions.coroutines}"
    const val coroutinesRx2 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Versions.coroutines}"
    const val fuel = "com.github.kittinunf.fuel:fuel:${Versions.fuel}"
    const val jsonIter = "com.jsoniter:jsoniter:${Versions.jsonIter}"
    const val khronos = "com.github.hotchemi:khronos:${Versions.khronos}"
    const val koinCore = "org.koin:koin-core:${Versions.koin}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val rxJava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val rxRelay = "com.jakewharton.rxrelay2:rxrelay:${Versions.rxRelay}"
    const val snakeYaml = "org.yaml:snakeyaml:${Versions.snakeYaml}"
    const val tornadoFx = "no.tornado:tornadofx:${Versions.tornadoFx}"
}

object AndroidDeps {
    const val androidxPreference = "androidx.preference:preference-ktx:${Versions.preferenceKtx}"
    const val ankoCommons = "org.jetbrains.anko:anko-commons:${Versions.anko}"
    const val ankoSdk25 = "org.jetbrains.anko:anko-sdk25:${Versions.anko}"
    const val anotherViewPager = "io.kri:anotherViewPager:${Versions.anotherViewPager}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val appUpdater = "com.github.javiersantos:AppUpdater:${Versions.appUpdater}"
    const val bungee = "com.github.Binary-Finery:Bungee:${Versions.bungee}"
    const val circularImageView = "com.github.abdularis:CircularImageView:${Versions.circularImageView}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.androidxcore}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val disposer = "io.sellmair:disposer:${Versions.disposer}"
    const val drawableToolbox = "com.github.duanhong169:drawabletoolbox:${Versions.drawableToolbox}"
    const val flashbar = "com.andrognito.flashbar:flashbar:${Versions.flashBar}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val inputMask = "com.redmadrobot:inputmask:${Versions.inputMask}"
    const val kFormMaster = "com.thejuki:k-form-master:${Versions.kFormMaster}"
    const val koinAndroidxViewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val kotpref = "com.chibatching.kotpref:kotpref:${Versions.kotpref}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleReactiveStreamsKtx = "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.lifecycle}"
    const val lightCalendarView = "jp.co.recruit_mp:LightCalendarView:${Versions.lightCalendarView}"
    const val maskedEditText = "com.github.santalu:mask-edittext:${Versions.maskEditText}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    const val materialDialogs = "com.afollestad.material-dialogs:core:${Versions.materialDialogs}"
    const val materialSpinner = "com.jaredrummler:material-spinner:${Versions.materialSpinner}"
    const val multiLineRadioGroup = "com.github.Gavras:MultiLineRadioGroup:${Versions.multiLineRadioGroup}"
    const val navigationFragment = "android.arch.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "android.arch.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val passcodeView = "in.arjsna:passcodeview:${Versions.passcodeView}"
    const val playServicesGcm = "com.google.android.gms:play-services-gcm:${Versions.playServicesGcm}"
    const val playServicesLocation = "com.google.android.gms:play-services-location:${Versions.playServicesLocation}"
    const val playServicesPlaces = "com.google.android.gms:play-services-places:${Versions.playServicesPlaces}"
    const val pugNotification = "com.github.halysongoncalves:pugnotification:${Versions.pugNotification}"
    const val quantum = "io.sellmair:quantum:${Versions.quantum}"
    const val quantumLiveData = "io.sellmair:quantum-livedata:${Versions.quantum}"
    const val quantumRx = "io.sellmair:quantum-rx:${Versions.quantum}"
    const val reactiveLocation = "pl.charmas.android:android-reactive-location2:${Versions.reactiveLocation2}@aar"
    const val reactiveNetwork = "com.github.pwittchen:reactivenetwork-rx2:${Versions.reactiveNetwork}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val rxPermission = "com.github.vanniktech:RxPermission:${Versions.rxPermissions}"
    const val simpleAuth = "com.jaychang:simpleauth-facebook:${Versions.simpleAuthFacebook}"
    const val smartScheduler = "io.hypertrack:smart-scheduler:${Versions.smartScheduler}"
    const val spinKit = "com.github.ybq:Android-SpinKit:${Versions.spinkit}"
    const val splittiesActivities = "com.louiscad.splitties:splitties-activities:${Versions.splitties}"
    const val splittiesAlertdialog = "com.louiscad.splitties:splitties-alertdialog:${Versions.splitties}"
    const val splittiesAlertdialogAppcompat = "com.louiscad.splitties:splitties-alertdialog-appcompat:${Versions.splitties}"
    const val splittiesAppctx = "com.louiscad.splitties:splitties-appctx:${Versions.splitties}"
    const val splittiesArchLifecycle = "com.louiscad.splitties:splitties-arch-lifecycle:${Versions.splitties}"
    const val splittiesArchRoom = "com.louiscad.splitties:splitties-arch-room:${Versions.splitties}"
    const val splittiesBitflags = "com.louiscad.splitties:splitties-bitflags:${Versions.splitties}"
    const val splittiesBundle = "com.louiscad.splitties:splitties-bundle:${Versions.splitties}"
    const val splittiesCheckedlazy = "com.louiscad.splitties:splitties-checkedlazy:${Versions.splitties}"
    const val splittiesCollections = "com.louiscad.splitties:splitties-collections:${Versions.splitties}"
    const val splittiesDimensions = "com.louiscad.splitties:splitties-dimensions:${Versions.splitties}"
    const val splittiesExceptions = "com.louiscad.splitties:splitties-exceptions:${Versions.splitties}"
    const val splittiesFragments = "com.louiscad.splitties:splitties-fragments:${Versions.splitties}"
    const val splittiesFragmentargs = "com.louiscad.splitties:splitties-fragmentargs:${Versions.splitties}"
    const val splittiesInitprovider = "com.louiscad.splitties:splitties-initprovider:${Versions.splitties}"
    const val splittiesIntents = "com.louiscad.splitties:splitties-intents:${Versions.splitties}"
    const val splittiesLifecycleCoroutines = "com.louiscad.splitties:splitties-lifecycle-coroutines:${Versions.splitties}"
    const val splittiesMainhandler = "com.louiscad.splitties:splitties-mainhandler:${Versions.splitties}"
    const val splittiesMainthread = "com.louiscad.splitties:splitties-mainthread:${Versions.splitties}"
    const val splittiesMaterialColors = "com.louiscad.splitties:splitties-material-colors:${Versions.splitties}"
    const val splittiesMaterialLists = "com.louiscad.splitties:splitties-material-lists:${Versions.splitties}"
    const val splittiesPreferences = "com.louiscad.splitties:splitties-preferences:${Versions.splitties}"
    const val splittiesResources = "com.louiscad.splitties:splitties-resources:${Versions.splitties}"
    const val splittiesSnackbar = "com.louiscad.splitties:splitties-snackbar:${Versions.splitties}"
    const val splittiesSystemservices = "com.louiscad.splitties:splitties-systemservices:${Versions.splitties}"
    const val splittiesToast = "com.louiscad.splitties:splitties-toast:${Versions.splitties}"
    const val splittiesTypesaferecyclerview = "com.louiscad.splitties:splitties-typesaferecyclerview:${Versions.splitties}"
    const val splittiesViews = "com.louiscad.splitties:splitties-views:${Versions.splitties}"
    const val splittiesViewsAppcompat = "com.louiscad.splitties:splitties-views-appcompat:${Versions.splitties}"
    const val splittiesViewsCardview = "com.louiscad.splitties:splitties-views-cardview:${Versions.splitties}"
    const val splittiesViewsDsl = "com.louiscad.splitties:splitties-views-dsl:${Versions.splitties}"
    const val splittiesViewsDslAppcompat = "com.louiscad.splitties:splitties-views-dsl-appcompat:${Versions.splitties}"
    const val splittiesViewsDslConstraintlayout = "com.louiscad.splitties:splitties-views-dsl-constraintlayout:${Versions.splitties}"
    const val splittiesViewsDslCoordinatorlayout = "com.louiscad.splitties:splitties-views-dsl-coordinatorlayout:${Versions.splitties}"
    const val splittiesViewsDslMaterial = "com.louiscad.splitties:splitties-views-dsl-material:${Versions.splitties}"
    const val splittiesViewsDslRecyclerview = "com.louiscad.splitties:splitties-views-dsl-recyclerview:${Versions.splitties}"
    const val splittiesViewsMaterial = "com.louiscad.splitties:splitties-views-material:${Versions.splitties}"
    const val splittiesViewsRecyclerview = "com.louiscad.splitties:splitties-views-recyclerview:${Versions.splitties}"
    const val splittiesViewsSelectable = "com.louiscad.splitties:splitties-views-selectable:${Versions.splitties}"
    const val splittiesViewsSelectableAppcompat = "com.louiscad.splitties:splitties-views-selectable-appcompat:${Versions.splitties}"
    const val splittiesViewsSelectableConstraintlayout = "com.louiscad.splitties:splitties-views-selectable-constraintlayout:${Versions.splitties}"
    const val spotsDialog = "com.github.d-max:spots-dialog:${Versions.spotsdialog}@aar"
    const val stateViews = "com.github.kobeumut:StateViews:${Versions.stateViews}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val unoxAndroid = "com.github.icarohs7:unox-android:${Versions.unoxAndroid}"
}

object AndroidKaptDeps {
    val core = listOf(
            "androidx.room:room-compiler:${Versions.room}"
    )
}

object TestDeps {
    val core = listOf(
            "org.bigtesting:fixd:${Versions.fixd}",
            "org.koin:koin-test:${Versions.koin}",
            "se.lovef:kotlin-assert-utils:${Versions.kotlinAssertUtils}"
    )

    val androidCore = core + listOf(
            "androidx.room:room-testing:${Versions.room}",
            "androidx.test:core:${Versions.testCore}",
            "org.robolectric:robolectric:${Versions.robolectric}"
    )
}

object AndroidTestDeps {
    val core = listOf(
            "androidx.test.espresso:espresso-contrib:${Versions.espresso}",
            "androidx.test.espresso:espresso-intents:${Versions.espresso}",
            "androidx.test:rules:${Versions.testRules}"
    ) + TestDeps.core.filterNot { it.contains("org.robolectric:robolectric") }

    const val barista = "com.schibsted.spain:barista:${Versions.barista}"
    const val testOrchestrator = "androidx.test:orchestrator:${Versions.testRules}"
}

object Versions {
    const val androidxcore = "1.0.1"
    const val anko = "0.10.8"
    const val anotherViewPager = "1.0.2"
    const val appCompat = "1.0.2"
    const val appUpdater = "2.7"
    const val arrow = "0.8.2"
    const val bungee = "master-SNAPSHOT"
    const val circularImageView = "1.2"
    const val constraintLayout = "1.1.3"
    const val coroutines = "1.1.0"
    const val disposer = "1.0.0"
    const val drawableToolbox = "1.0.7"
    const val flashBar = "1.0.3"
    const val fragment = "1.0.0"
    const val fuel = "1.16.0"
    const val glide = "4.8.0"
    const val inputMask = "4.0.0"
    const val jsonIter = "0.9.19"
    const val kFormMaster = "6.1.1"
    const val khronos = "0.9.0"
    const val koin = "1.0.2"
    const val kotlin = "1.3.11"
    const val kotpref = "2.6.0"
    const val lifecycle = "2.0.0"
    const val lightCalendarView = "1.0.1"
    const val maskEditText = "1.1.1"
    const val materialDesign = "1.0.0"
    const val materialDialogs = "2.0.0-rc7"
    const val materialSpinner = "1.3.1"
    const val multiLineRadioGroup = "v1.0.0.6"
    const val navigation = "1.0.0-alpha09"
    const val passcodeView = "1.2.1"
    const val playServicesGcm = "12.0.1"
    const val playServicesLocation = "16.0.0"
    const val playServicesPlaces = "16.0.0"
    const val preferenceKtx = "1.0.0"
    const val pugNotification = "1.8.1"
    const val quantum = "1.0.0-RC.0"
    const val reactiveLocation2 = "2.1"
    const val reactiveNetwork = "3.0.2"
    const val recyclerView = "1.0.0"
    const val room = "2.0.0"
    const val rxJava = "2.2.5"
    const val rxPermissions = "0.7.0"
    const val rxRelay = "2.1.0"
    const val simpleAuthFacebook = "2.1.4"
    const val smartScheduler = "0.0.14"
    const val snakeYaml = "1.23"
    const val spinkit = "1.2.0"
    const val splitties = "3.0.0-alpha02"
    const val spotsdialog = "1.1"
    const val stateViews = "0.5"
    const val timber = "4.7.1"
    const val tornadoFx = "1.7.17"
    const val unoxAndroid = "5c43f61b45"

    const val barista = "2.7.1"
    const val fixd = "1.0.3"
    const val kotlinAssertUtils = "0.8.0"
    const val robolectric = "4.1"
    const val testCore: String = "1.1.0"

    const val espresso = "3.1.1"
    const val testRules = "1.1.1"
}