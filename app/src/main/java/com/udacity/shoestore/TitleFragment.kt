package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentTitleBinding
import kotlinx.android.synthetic.main.fragment_title.*


// TODO: Rename parameter arguments, choose names that match


class TitleFragment : Fragment() {

   //private var viewModel = ViewModelProvider(this, viewModel).get(TitleViewModel::class.java)

    private val viewModel: TitleViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Observing the showToast event, call in the textClick function
        viewModel.showToast.observe(this, Observer { message ->
            Toast.makeText(context, message , Toast.LENGTH_SHORT).show()
        })
        // Observing the navigate event, call in the textClick function
        viewModel.navigate.observe(this, Observer {
            findNavController().navigate(R.id.action_titleFragment_to_welcomeFragment)
        })

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTitleBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        binding.viewModel = viewModel
        return binding.root


    }



}
