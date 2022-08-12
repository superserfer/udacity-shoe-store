package com.example.shoestore.models

import androidx.databinding.Bindable

data class Shoe(
    var name: String,
    var company: String,
    var size: Int,
    var description: String
) {
}
