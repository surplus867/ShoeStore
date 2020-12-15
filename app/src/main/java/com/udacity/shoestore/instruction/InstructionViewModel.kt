package com.udacity.shoestore.instruction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionViewModel : ViewModel() {
    // Navigation event to show navigation
    var navigationItem = MutableLiveData<String>()
    val navigate: LiveData<String> get() = navigationItem



    fun testClick() {

        navigationItem.value = ""


    }


}