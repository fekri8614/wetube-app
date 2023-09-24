package info.fekri8614.wetube.ui.feature.main

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.burnoo.cokoin.navigation.getNavController
import info.fekri8614.wetube.ui.theme.*
import info.fekri8614.wetube.ui.theme.Shapes
import info.fekri8614.wetube.ui.theme.robotoFamily
import info.fekri8614.wetube.util.MainTopBar
import info.fekri8614.wetube.util.textLengthStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val navigation = getNavController()

    Scaffold(
        topBar = {
            MainTopBar(
                onMainIconClicked = { /*TODO: Handle it*/ },
                onNotificationClicked = { /*TODO: Handle it*/ },
                onSearchClicked = { /*TODO: Handle it*/ },
                personImage = "https://engineering.unl.edu/images/staff/Kayla-Person.jpg",
                onPersonClicked = { /*TODO: Handle it*/ }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                AdsBar(onRedMoreClicked = {})
            }
        }
    )
}

// -------------------------------------------------

@Composable
fun AdsBar(
    onRedMoreClicked: (String) -> Unit
) {
    val configuration = LocalConfiguration.current
    Box(
        modifier = Modifier
            .background(GreyLight)
            .fillMaxWidth()
            .height(55.dp)
            .padding(horizontal = 8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            val textLength =
                if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 90 else 30
            Text(
                text = textLengthStyle(
                    txt = "Som text some text, sometex, text text text Som text some text, sometex, text text text xt some text, sometex, text text text",
                    length = textLength
                ),
                style = TextStyle(
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 16.sp
                )
            )

            TextButton(
                onClick = { onRedMoreClicked.invoke("") }, // pass the real one(s)
                shape = Shapes.small,
            ) {
                Text(
                    text = "Read more",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                    )
                )
            }
        }
    }
}


