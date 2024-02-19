package com.example.test_9.presentation.screen

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.test_9.databinding.FragmentImageUploadBinding
import com.example.test_9.presentation.base.BaseFragment
import com.example.test_9.presentation.state.ImageState
import kotlinx.coroutines.launch

class ImageUploadFragment :
    BaseFragment<FragmentImageUploadBinding>(FragmentImageUploadBinding::inflate) {
    private lateinit var viewModel: ImageViewModel

    override fun bind() {
    }

    override fun bindListeners() {
        binding.btnAddImage.setOnClickListener {
            val bottomFragment = BottomFragment()
            bottomFragment.show(parentFragmentManager, "bottom_fragment")
        }
    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.imageState.collect {
                    handleState(it)
                }
            }
        }
    }

    private fun handleState(state: ImageState) {
        state.image?.let {
            binding.ivSelectedImage.setImageURI(it)
        }
    }

}