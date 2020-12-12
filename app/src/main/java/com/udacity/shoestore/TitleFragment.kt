package com.udacity.shoestore

import android.content.ClipData.Item
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentTitleBinding
import kotlinx.android.synthetic.main.fragment_title.*


// TODO: Rename parameter arguments, choose names that match


class TitleFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTitleBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        binding.fragment = this
        return binding.root


    }

    fun testClick() {

        if (emailAddress_ed.text.isEmpty() && password_ed.text.toString() != "Bilbo"){
            Toast.makeText(context,"Please Enter your email address", Toast.LENGTH_SHORT).show()
        }else{
            findNavController().navigate(R.id.action_titleFragment_to_WelcomeFragment)

        }


    }

}