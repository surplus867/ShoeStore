package com.udacity.shoestore.shoeslist

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoesListViewModel : ViewModel() {

    private var _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get()  = _shoesList

    init {

        Timber.i("ShoesListViewModel created!")

        _shoesList.value = mutableListOf()
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoesListViewModel destroyed!")

    }

   /* fun addNewPairOfShoes(shoeName: String, shoeSize: String, companyName: String, description: String) {}
        val newShoe = Shoe(
                shoeName,
                shoeSize. toDouble(),
                companyName,
                description
        )
        _shoesList.value?.add(newShoe)*/
}


