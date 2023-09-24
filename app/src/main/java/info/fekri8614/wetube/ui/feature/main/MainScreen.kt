package info.fekri8614.wetube.ui.feature.main

import android.content.res.Configuration
import android.inputmethodservice.Keyboard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.burnoo.cokoin.navigation.getNavController
import info.fekri8614.wetube.ui.theme.*
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
        bottomBar = {
            BottomNavigator {
                BottomAppBarItem(icon = Icons.Outlined.Home, isChecked = true, onClicked = {})
                BottomAppBarItem(icon = Icons.Outlined.Home, isChecked = false, onClicked = {})
                BottomAppBarItem(icon = Icons.Outlined.Home, isChecked = false, onClicked = {})
            }
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

// --------------------------------------------------

@Composable
fun BottomNavigator(
    modifier: Modifier = Modifier,
    containerColor: Color = BottomAppBarDefaults.containerColor,
    contentColor: Color = contentColorFor(containerColor),
    tonalElevation: Dp = BottomAppBarDefaults.ContainerElevation,
    contentPadding: PaddingValues = BottomAppBarDefaults.ContentPadding,
    windowInsets: WindowInsets = BottomAppBarDefaults.windowInsets,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        color = containerColor,
        contentColor = contentColor,
        tonalElevation = tonalElevation,
        modifier = modifier
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .windowInsetsPadding(windowInsets)
                .height(80.dp)
                .padding(contentPadding),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            content = content
        )
    }
}

@Composable
fun BottomAppBarItem(icon: ImageVector, isChecked: Boolean, onClicked: (Boolean) -> Unit) {
    IconButton(onClick = { onClicked(false) }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(imageVector = icon, contentDescription = null)
            if (isChecked) {
                Spacer(
                    modifier = Modifier
                        .background(Color.Red)
                        .size(width = 10.dp, height = 5.dp)
                        .clip(RoundedCornerShape(60))
                )
            }
        }
    }
}
