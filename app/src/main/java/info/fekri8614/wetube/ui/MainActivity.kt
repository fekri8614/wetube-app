package info.fekri8614.wetube.ui

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.burnoo.cokoin.Koin
import dev.burnoo.cokoin.navigation.KoinNavHost
import info.fekri8614.wetube.di.myModules
import info.fekri8614.wetube.ui.feature.main.MainScreen
import info.fekri8614.wetube.ui.feature.splash.SplashScreen
import info.fekri8614.wetube.ui.theme.WeTubeTheme
import info.fekri8614.wetube.util.MyScreens
import org.koin.android.ext.koin.androidContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR
        setContent {
            WeTubeTheme {
                Koin(appDeclaration = {
                     androidContext(this@MainActivity)
                    modules(myModules)
                }) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color.White
                    ) {
                        MainAppUi()
                    }
                }
            }
        }
    }
}

@Composable
fun MainAppUi() {
    val controller = rememberNavController()

    KoinNavHost(navController = controller, startDestination = MyScreens.SplashScreen.route) {

        composable(MyScreens.SplashScreen.route) {
            SplashScreen()
        }

        composable(MyScreens.MainScreen.route) {
            MainScreen()
        }

    }

}
