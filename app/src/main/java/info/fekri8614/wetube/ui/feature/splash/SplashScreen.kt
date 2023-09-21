package info.fekri8614.wetube.ui.feature.splash

import android.os.Handler
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.burnoo.cokoin.navigation.getNavController
import info.fekri8614.wetube.ui.theme.robotoFamily
import info.fekri8614.wetube.util.MainAppIcon
import info.fekri8614.wetube.util.MyScreens
import info.fekri8614.wetube.util.NetworkChecker

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val navigation = getNavController()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            MainAppIcon()
            Spacer(modifier = modifier.fillMaxHeight(0.01f))
            Text(
                text = "WeTube!",
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 20.sp
            )
        }
    }

    // navigate to another page after 3secs,
    // if internet is connected
    Handler().postDelayed({
        if (NetworkChecker(context).isInternetConnected) {
            navigation.navigate(MyScreens.MainScreen.route)
        } else {
            Toast.makeText(
                context,
                "Please, check your Internet Connection",
                Toast.LENGTH_SHORT
            ).show()
        }
    }, 3000)

}