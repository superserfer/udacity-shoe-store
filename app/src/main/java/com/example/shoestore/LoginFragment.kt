package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.shoestore.databinding.FragmentInstructionBinding
import com.example.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )
        binding.buttonRegister.setOnClickListener { view: View -> validateInput(view) }
        binding.buttonSignin.setOnClickListener { view: View -> validateInput(view) }
        return binding.root
    }

    private fun validateInput(v: View) {
        var isValid = true
        if (binding.editTextTextEmailAddress.text.isNullOrBlank()) {
            binding.editTextTextEmailAddress.error = getString(R.string.invalid_username)
            isValid = false
        }
        if (binding.editTextTextPassword.text.isNullOrBlank()) {
            binding.editTextTextPassword.error = getString(R.string.invalid_password)
            isValid = false
        }
        if (isValid) {
           Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_welcomeFragment2)
        }
    }
}