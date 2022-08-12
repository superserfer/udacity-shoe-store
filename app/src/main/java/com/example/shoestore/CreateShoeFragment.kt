package com.example.shoestore

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.shoestore.databinding.FragmentCreateShoeBinding
import com.example.shoestore.models.CreateShoeViewModel
import com.example.shoestore.models.ShoeListViewModel

class CreateShoeFragment : Fragment() {

    private lateinit var viewModel: CreateShoeViewModel
    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    private lateinit var binding: FragmentCreateShoeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_shoe, container, false)
        viewModel = ViewModelProvider(this).get(CreateShoeViewModel::class.java)


        binding.createShoeViewModel = viewModel

        viewModel.eventCanceled.observe(viewLifecycleOwner, Observer {
            if (it) {
                Navigation.findNavController(requireView()).navigate(CreateShoeFragmentDirections.actionCreateShoeFragmentToShoeListFragment())
                viewModel.onCanceled()
            }
        })

        viewModel.eventSaved.observe(viewLifecycleOwner, Observer {
            if (it) {
                shoeListViewModel.addShoe(viewModel.newShoe.value!!)
                Navigation.findNavController(requireView()).navigate(CreateShoeFragmentDirections.actionCreateShoeFragmentToShoeListFragment())
                viewModel.onSaved()
            }
        })

        return binding.root
    }
}