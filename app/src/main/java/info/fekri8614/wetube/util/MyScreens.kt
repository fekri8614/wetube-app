package info.fekri8614.wetube.util

sealed class MyScreens(val route: String) {
    object SplashScreen: MyScreens("splashScreen")
    object MainScreen: MyScreens("mainScreen")
    object ShortsScreen: MyScreens("shortsScreen")
    object AddScreen: MyScreens("addScreen")
    object SubsScreen: MyScreens("subscriptionsScreen")
    object LibraryScreen: MyScreens("libraryScreen")
}
