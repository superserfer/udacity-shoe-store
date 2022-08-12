package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.shoestore.databinding.FragmentInstructionBinding
import com.example.shoestore.databinding.FragmentWelcomeBinding

class InstructionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding: FragmentInstructionBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instruction, container, false
        )
        binding.buttonNavInstructions.setOnClickListener { v:View ->
            Navigation.findNavController(v).navigate(R.id.action_instructionFragment_to_shoeListFragment)
        }
        return binding.root
    }
}