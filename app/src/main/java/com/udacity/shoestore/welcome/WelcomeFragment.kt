package com.udacity.shoestore.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import viewModel.ShareViewModel

class WelcomeFragment : Fragment() {


    private val viewModel: ShareViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Observing the navigate event, call in the textClick function
        viewModel.instructionNavigate.observe(this, Observer {
            findNavController().navigate(R.id.action_welcomeFragment_to_instructionFragment)
        })

    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWelcomeBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        binding.viewModel = viewModel // Error
        return binding.root


    }
}
