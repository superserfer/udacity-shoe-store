package com.example.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.databinding.FragmentShoeListBinding
import com.example.shoestore.models.Shoe
import com.example.shoestore.models.ShoeListViewModel

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.fabAddShoe.setOnClickListener { v: View ->
            Navigation.findNavController(v).navigate(R.id.action_shoeListFragment_to_createShoeFragment)
        }
        
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { newShoeList ->
            binding.shoeList.removeAllViews()
            var i = 0
            newShoeList.forEach { s: Shoe ->
                i++
                binding.shoeList.addView(
                    initButton(s, i)
                )
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.loginFragment) {
            view!!.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initButton(shoe: Shoe, prefix: Int): Button {
        val shoeButton = Button(context)
        shoeButton.text = prefix.toString() + ". " + shoe.name
        shoeButton.textAlignment = 2
        shoeButton.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT)
        shoeButton.setOnClickListener {
            viewModel.selectShoeByIndex(prefix - 1)
            Navigation.findNavController(view!!).navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }
        return shoeButton
    }
}