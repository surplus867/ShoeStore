package com.udacity.shoestore

import android.util.Log
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
    var shoesize = ObservableField<String>("0.0")
    var description = ObservableField<String>("")
    var shoeList = ObservableField<ArrayList<Shoe>>()
    // Toast event to show toast
    var toastItem = MutableLiveData<String>()
    val showToast: LiveData<String> get() = toastItem
    // Navigation event to show navigation
    var welcomeNavigationItem = MutableLiveData<String>()
    val welcomeNavigate: LiveData<String> get() = welcomeNavigationItem
    var instructionNavigationItem = MutableLiveData<String>()
    val instructionNavigate: LiveData<String> get() = instructionNavigationItem
    var shoeListNavigationItem = MutableLiveData<String>()
    val shoeListNavigate: LiveData<String> get() = shoeListNavigationItem
    var shoeDetailNavigationItem = MutableLiveData<String>()
    val shoeDetailNavigate: LiveData<String> get() = shoeDetailNavigationItem
    var shoeListBackNavigationItem = MutableLiveData<ArrayList<Shoe>>()
    val shoeListBackNavigate: LiveData<ArrayList<Shoe>> get() = shoeListBackNavigationItem

    // log-in Screen to Welcome Screen
    fun submitLogIn() {
        // if the username is empty, fire a toast event
        if (username.get().orEmpty() != "Bilbo" && password.get().orEmpty() != "Bilbo") {
            toastItem.value = " Please enter the correct email and password"
        // or else, fire a event to the WelcomeScreen
         } else {
            welcomeNavigationItem.postValue("")
        }
    }
    // Welcome Screen to Instruction Screen
    fun instructionNavigation() {
        instructionNavigationItem.postValue("")
    }
    // Instruction Screen to Shoe-List Screen
    fun shoeListNavigation() = shoeListNavigationItem.postValue("")

    // Shoe-List Screen to Shoe-Detail Screen
    fun shoeDetailNavigation() = shoeDetailNavigationItem.postValue("")

    // navigate back to shoeList
    fun backShoeList() = shoeListBackNavigationItem.postValue(shoeList.get())

    fun submitShoe() {
        val localShoeList = ArrayList<Shoe>()
        val shoe = Shoe(shoename.get().orEmpty(),shoesize.get()?.toDouble() ?: 0.0,company.get().orEmpty(),description.get().orEmpty())
        localShoeList.add(shoe)
        shoeList.set(localShoeList)
        // navigate to list after save
       backShoeList()
    }

    fun showShoeList() {
        // TODO grab shoeList and display the text either in text view or a recylcerview, *shoeRow
        var exampleText = ""
        shoeList.get()?.forEach {
            // You need to iterate through the list with a for loop, you need to add the previous text to the new text and
            // have a return carriage (/n) at the end of each line so that it put each shoe on a new line.
            // Append the shoes items together. Append a string to string and return carriage at the end.
            exampleText += "Shoe name ${it.name} Company: ${it.company} /n"
        }

        // sets the text to the list of shoes
        shoes.set(exampleText)

        //toastItem.value = shoeList.get()?.first()?.name.orEmpty()
    }
}