package com.example.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel: ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

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
        _email.value = ""
        _password.value = ""
        _shoeList.value = mutableListOf<Shoe>()
    }

    init {
        _shoeList.value = mutableListOf<Shoe>()
        _selectedShoe.value = Shoe("", "", 0, "")
        _email.value = ""
        _password.value = ""
    }
}