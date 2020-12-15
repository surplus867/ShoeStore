package com.udacity.shoestore.title

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TitleViewModel : ViewModel() {

    var username = ObservableField<String>("")

    var password = ObservableField<String>("")
    // Toast event to show toast
    var toastItem = MutableLiveData<String>()
    val showToast: LiveData<String> get() = toastItem
    // Navigation event to show navigation
    var navigationItem = MutableLiveData<String>()
    val navigate: LiveData<String> get() = navigationItem



    fun testClick() {

        // if the username is empty, fire a toast event
        if (username.get().orEmpty() != "Bilbo" && password.get().orEmpty() != "Bilbo" ){
            toastItem.value = "Please enter the correct email and password"
        // or else, fire a event to the WelcomeScreen
        }else{
            navigationItem.value = ""


        }


    }


}


