package com.udacity.shoestore

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShareViewModel : ViewModel() {
    // Observables
    var username = ObservableField<String>("")
    var password = ObservableField<String>("")
    var shoes = ObservableField<String>("")
    var shoename = ObservableField<String>("")
    var company = ObservableField<String>("")
    var shoeSize = ObservableField<String>("0.0")
    var description = ObservableField<String>("")
    var shoeList = ArrayList<Shoe>()

    // Navigation event to show navigation
    val welcomeNavigationEvent: MutableLiveData<SingleLiveEvent<String>> by lazy { MutableLiveData<SingleLiveEvent<String>>() }
    val shoeDetailNavigationEvent: MutableLiveData<SingleLiveEvent<String>> by lazy { MutableLiveData<SingleLiveEvent<String>>() }
    val shoeListBackNavigationEvent: MutableLiveData<SingleLiveEvent<ArrayList<Shoe>>> by lazy { MutableLiveData<SingleLiveEvent<ArrayList<Shoe>>>() }
    val toastEvent: MutableLiveData<SingleLiveEvent<String>> by lazy { MutableLiveData<SingleLiveEvent<String>>() }
    val instructionNavigationEvent: MutableLiveData<SingleLiveEvent<String>> by lazy { MutableLiveData<SingleLiveEvent<String>>() }
    val shoeListNavigationEvent: MutableLiveData<SingleLiveEvent<String>> by lazy { MutableLiveData<SingleLiveEvent<String>>() }

    // log-in Screen to Welcome Screen
    fun submitLogIn() {
        // if the username is empty, fire a toast event
        if (username.get().orEmpty() != "Bilbo" && password.get().orEmpty() != "Bilbo") {
            toastEvent.postValue(SingleLiveEvent("Please enter the correct email and password"))
            // or else, fire a event to the WelcomeScreen
        } else {
            welcomeNavigationEvent.postValue(SingleLiveEvent(""))
        }
    }

    // Welcome Screen to Instruction Screen
    fun instructionNavigation() {
        instructionNavigationEvent.postValue(SingleLiveEvent(""))
    }
    // Instruction Screen to Shoe-List Screen
    fun shoeListNavigation() = shoeListNavigationEvent.postValue(SingleLiveEvent(""))
    // Shoe-List Screen to Shoe-Detail Screen
    fun shoeDetailNavigation() = shoeDetailNavigationEvent.postValue(SingleLiveEvent(""))
    // navigate back to shoeList
    fun backShoeList() = shoeListBackNavigationEvent.postValue(SingleLiveEvent(shoeList))

    fun submitShoe() {
        val shoe = Shoe(shoename.get().orEmpty(), shoeSize.get()?.toDouble()
                ?: 0.0, company.get().orEmpty(), description.get().orEmpty())
        shoeList.add(shoe)

        // clear fields after navigate example.
        shoename.set("")
        shoeSize.set("")
        company.set("")
        description.set("")
        // navigate to list after save
        backShoeList()
    }

    fun showShoeList() {
        var shoeRow = ""
        shoeList.forEach {
            // if list size 1 dont add to next line
            if (shoeList.size == 1) {
                shoeRow = "Shoe name : ${it.name} Company : ${it.company} Shoe size : ${it.size} Description: ${it.description}"
            } else {
                shoeRow += "\nShoe name : ${it.name} Company : ${it.company} Shoe size : ${it.size} Description: ${it.description}"
            }
        }
        shoes.set(shoeRow)
    }
}