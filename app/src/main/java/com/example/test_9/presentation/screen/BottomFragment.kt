package com.example.test_9.presentation.screen

import android.content.Intent
import android.graphics.Camera
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.example.test_9.R
import com.example.test_9.databinding.FragmentBottomBinding
import com.example.test_9.presentation.base.BaseFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentBottomBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ImageViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setUp() {
        listener()
    }

    private fun listener() {
        binding.btnTakePicture.setOnClickListener {
            openCamera()
        }

        binding.btnGallery.setOnClickListener {
            openGallery()
        }
    }

    private fun openCamera() {
        val pickImg = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        changeImage.launch(pickImg)
    }

    private fun openGallery() {
        val pickImg = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        changeImage.launch(pickImg)
    }

    private val changeImage =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            val data = it.data
            val imgUri = data?.data
            viewModel.setNewImage(imgUri)
        }
}