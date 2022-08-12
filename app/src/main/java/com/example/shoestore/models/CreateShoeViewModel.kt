package com.example.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateShoeViewModel: ViewModel() {

    val newShoe = MutableLiveData<Shoe>()

    private val _eventSaved = MutableLiveData<Boolean>()
    val eventSaved: LiveData<Boolean>
        get() = _eventSaved

    private val _eventCanceled = MutableLiveData<Boolean>()
    val eventCanceled: LiveData<Boolean>
        get() = _eventCanceled

    init {
        _eventSaved.value = false
        _eventCanceled.value = false
        newShoe.value = Shoe("Sneakers","Nike",2,"test")
    }

    fun exit(shouldSave: Boolean) {
        if (shouldSave) {
            _eventSaved.value = true
        } else {
            _eventCanceled.value = true
        }
    }

    fun onSaved() {
        _eventSaved.value = false
    }

    fun onCanceled() {
        _eventCanceled.value = false
    }
}