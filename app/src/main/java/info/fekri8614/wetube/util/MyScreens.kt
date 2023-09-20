package info.fekri8614.wetube.util

sealed class MyScreens(val route: String) {
    object SplashScreen: MyScreens("splashScreen")
    object EntryScreenFirst: MyScreens("entryScreenFirst")
    object EntryScreenSecond : MyScreens("entryScreenSecond")
    object MainScreen: MyScreens("mainScreen")
}
