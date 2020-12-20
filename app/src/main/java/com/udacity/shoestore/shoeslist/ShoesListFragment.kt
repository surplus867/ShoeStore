package com.udacity.shoestore.shoeslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import viewModel.ShareViewModel

class ShoesListFragment : Fragment() {


    private val viewModel: ShareViewModel by activityViewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Observing the showToast event, call in the textClick function
        viewModel.showToast.observe(this, Observer { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

        })
        // Observing the navigate event, call in the textClick function
        viewModel.shoeDetailNavigate.observe(this, Observer {
            findNavController().navigate(R.id.action_shoelist_destination_to_shoeDetailFragment)
        })

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding=
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.showShoeList()
    }
}