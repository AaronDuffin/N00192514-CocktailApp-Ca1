package com.example.cocktailsapps

import android.util.Log
import androidx.lifecycle.*
import com.example.cocktailsapps.data.CocktailEntity
import com.example.cocktailsapps.dataaccess.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    // MutableLiveData - means this list can be changed at runtime
    // Note!!! _plants above is private, only visible here the underscore represents variables not exposed to the UI layer (fragments)
    private val _cocktails: MutableLiveData<List<CocktailEntity>> = MutableLiveData()

    // Plants is exposed to the UI - Fragment
    val plants: LiveData<List<CocktailEntity>>
        // get() This is a getter() function, which returns the list of plants as LiveData
        get() = _cocktails

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    // No Longer get the data from SampleDataProvider
    init {
//        // here we get the plant list data to share with the user interface
        getCocktails()
    }

    private fun getCocktails() {
        // web-access so run in a background thread - Coroutine
        viewModelScope.launch {
            _isLoading.value = true
            val fetchedCocktails = RetrofitInstance.api.getCocktails()
            Log.i(TAG, "List of Cocktails : $fetchedCocktails")
            _cocktails.value = fetchedCocktails.drinks
            _isLoading.value = false
        }
    }
}