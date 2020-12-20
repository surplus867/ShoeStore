package viewModel

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
    var shoeListBackNavigationItem = MutableLiveData<String>()
    val shoeListBackNavigate: LiveData<String> get() = shoeListBackNavigationItem

    // log-in Screen to Welcome Screen
    fun submitLogIn() {
        // if the username is empty, fire a toast event
        if(username.get().orEmpty() != "Bilbo" && password.get().orEmpty() != "Bilbo"){
            toastItem.value = " Please enter the correct email and password"
        // or else, fire a event to the WelcomeScreen
        }else{
            welcomeNavigationItem.value = ""
        }
    }
    // Welcome Screen to Instruction Screen
    fun instructionNavigation() {
        instructionNavigationItem.value = ""
    }
    // Instruction Screen to Shoe-List Screen
    fun shoeListNavigation() {
        shoeListNavigationItem.value = ""
    }
    // Shoe-List Screen to Shoe-Detail Screen
    fun shoeDetailNavigation() {
        shoeDetailNavigationItem.value = ""

    }

    //TODO name correctly ex.  submitShoe()
    fun submitShoe() {
        Log.d("Bilbo", "ShoeName: ${shoename.get().orEmpty()}")
        val shoe = Shoe(shoename.get().orEmpty(),shoesize.get()?.toDouble() ?: 0.0,company.get().orEmpty(),description.get().orEmpty())
        shoeList.get()?.add(shoe)
        shoes.set("Name: ${shoename.get().orEmpty()} Company: ${company.get().orEmpty()}")
        // navigate to list after save
        shoeListBackNavigationItem.value = ""
        //shoeDetailNavigationItem.value = ""
    }

    fun backShoeList() {
        // navigate back to shoeList
        shoeListBackNavigationItem.value = ""
        //shoeDetailNavigationItem.value = ""
    }

    fun showShoeList() {
        Log.d("bilbo","Name: ${shoeList.get()?.first()?.name.orEmpty()} Company: ${shoeList.get()?.first()?.company.orEmpty()}")

    }
}


