package info.fekri8614.wetube.ui.feature.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val isHomeSelected = mutableStateOf(true)
    val isShortsSelected = mutableStateOf(false)
    val isVideoLibSelected = mutableStateOf(false)

    fun homeSelected() {
        isShortsSelected.value = false
        isVideoLibSelected.value = false
    }

    fun shortsSelected() {
        isHomeSelected.value = false
        isVideoLibSelected.value = false
    }

    fun videoLibSelected() {
        isHomeSelected.value = false
        isShortsSelected.value = false
    }
}