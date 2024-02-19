package com.example.test_9.presentation.state

import android.net.Uri

data class ImageState(
    val image: Uri? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
