package com.udacity.shoestore.shoeslist

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShareViewModel : ViewModel() {
    // Observables
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
    var shoeListNavigationItem = MutableLiveData<String>()
    val shoeListNavigate: LiveData<String> get() = shoeListNavigationItem
    var shoeDetailNavigationItem = MutableLiveData<String>()
    val shoeDetailNavigate: LiveData<String> get() = shoeDetailNavigationItem

    //TODO name correctly ex.  submitShoe()
    fun testClick() {
        Log.d("Bilbo", "ShoeName: ${shoename.get().orEmpty()}")
        val shoe = Shoe(shoename.get().orEmpty(),shoesize.get()?.toDouble() ?: 0.0,company.get().orEmpty(),description.get().orEmpty())
        shoeList.get()?.add(shoe)
        shoes.set("Name: ${shoename.get().orEmpty()} Company: ${company.get().orEmpty()}")
        // navigate to list after save
        shoeDetailNavigationItem.value = ""
    }

    fun testClick2() {
        // navigate back to shoeList
        shoeDetailNavigationItem.value = ""
    }
    // example to start
    fun shoeListNavigation() {
        shoeListNavigationItem.value = ""
    }

    fun showShoeList() {
        Log.d("bilbo","Name: ${shoeList.get()?.first()?.name.orEmpty()} Company: ${shoeList.get()?.first()?.company.orEmpty()}")

        //shoeList.get()?.forEach{
          //  shoes.set("${it.name} ${it.company}")
       // }

    }
}


