package info.fekri8614.wetube.util

sealed class MyScreens(val route: String) {
    object SplashScreen: MyScreens("splashScreen")
    object MainScreen: MyScreens("mainScreen")
    object ShortsScreen: MyScreens("shortsScreen")
    object VideoLibraryScreen: MyScreens("videoLibraryScreen")
}
