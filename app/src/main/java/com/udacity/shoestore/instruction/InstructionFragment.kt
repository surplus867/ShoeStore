package com.udacity.shoestore.instruction

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
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.ShareViewModel

class InstructionFragment : Fragment() {

    private val viewModel: ShareViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Observing the navigate event, call in the textClick function
        viewModel.shoeListNavigate.observe(this, Observer {
            findNavController().navigate(R.id.action_instruction_destination_to_shoesListFragment)
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentInstructionBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

}