package info.fekri8614.wetube.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import info.fekri8614.wetube.R
import info.fekri8614.wetube.ui.theme.Shapes
import info.fekri8614.wetube.ui.theme.robotoFamily

// ui things here

@Composable
fun MainAppIcon() {
    Image(
        painterResource(id = R.drawable.ic_youtube),
        contentDescription = null
    )
}

// ----

@ExperimentalMaterial3Api
@Composable
fun MainTopBar(
    onMainIconClicked: () -> Unit,
    onNotificationClicked: () -> Unit,
    onSearchClicked: () -> Unit,
    onPersonClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "WeTube!",
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        },
        navigationIcon = {
            IconButton(onClick = onMainIconClicked, content = { MainAppIcon() })
        },
        actions = {
            IconButton(
                onClick = onNotificationClicked,
                content = {
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = null
                    )
                }
            )
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = null
                )
            }
            IconButton(onClick = onPersonClicked) {
                Icon(Icons.Outlined.Person, contentDescription = null)
            }
        }
    )
}

// ----

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
                .height(60.dp)
                .padding(contentPadding),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            content = content
        )
    }
}

@Composable
fun BottomAppBarItem(icon: Int, isChecked: Boolean, onClicked: () -> Unit) {
    val iconColor = if (isChecked) Color.Red else Color.Black
    IconButton(onClick = onClicked) {
        Icon(
            painter = painterResource(id = icon),
            tint = iconColor,
            contentDescription = null,
        )
    }
}
