package com.udacity.shoestore.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentTitleBinding

class WelcomeFragment : Fragment() {


    private val viewModel: WelcomeViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Observing the navigate event, call in the textClick function
        viewModel.navigate.observe(this, Observer {
            findNavController().navigate(R.id.action_titleFragment_to_WelcomeFragment)
        })

    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTitleBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        binding.viewModel = viewModel // Error
        return binding.root


    }
}