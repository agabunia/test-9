package com.example.test_9.presentation.screen

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.test_9.presentation.state.ImageState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow

class ImageViewModel : ViewModel() {

    private val _imageState = MutableStateFlow(ImageState())
    val imageState: SharedFlow<ImageState> = _imageState.asStateFlow()

    fun setNewImage(uri: Uri?) {
        _imageState.value = ImageState(image = uri)
    }

}