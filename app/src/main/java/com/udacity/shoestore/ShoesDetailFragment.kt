package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import viewModel.ShareViewModel

class ShoesDetailFragment : Fragment() {

    private val viewModel: ShareViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentShoeDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.viewModel = viewModel
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Observing the showToast event, call in the textClick function
        viewModel.showToast.observe(this, Observer { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

        })
        // Observing the navigate event, call in the textClick function
        viewModel.shoeListBackNavigationItem.observe(this, Observer {
            findNavController().navigateUp()
        })

    }

}