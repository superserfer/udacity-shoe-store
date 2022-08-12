package com.example.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel: ViewModel() {

    val email = MutableLiveData<String>()

    val password = MutableLiveData<String>()

    private val _selectedShoe = MutableLiveData<Shoe>()
    val selectedShoe: LiveData<Shoe>
        get() = _selectedShoe

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    fun addShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
    }

    fun selectShoeByIndex(index: Int) {
        _selectedShoe.value = _shoeList.value!![index]
    }

    fun logout() {
        email.value = ""
        password.value = ""
        _shoeList.value = mutableListOf<Shoe>()
    }

    init {
        _shoeList.value = mutableListOf<Shoe>()
        _selectedShoe.value = Shoe("", "", 0, "")
        email.value = ""
        password.value = ""
    }
}