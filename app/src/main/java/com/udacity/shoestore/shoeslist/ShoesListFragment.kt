package com.udacity.shoestore.shoeslist

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.EventObserver
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.ShareViewModel

class ShoesListFragment : Fragment() {


    private val viewModel: ShareViewModel by activityViewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Observing the showToast event, call in the textClick function
        viewModel.toastEvent.observe(this, EventObserver { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        })

        // Observing the navigate event, call in the textClick function
        viewModel.shoeDetailNavigationEvent.observe(this, EventObserver {
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
        //binding.shoesListViewModel = shoesListViewModel
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.showShoeList()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.title_destination) {
            logout()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun logout() {
        findNavController().navigate(R.id.action_shoeList_destination_to_title_destination)
    }

}