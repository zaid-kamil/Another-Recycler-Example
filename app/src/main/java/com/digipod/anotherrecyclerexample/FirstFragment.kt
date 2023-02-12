package com.digipod.anotherrecyclerexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import androidx.navigation.fragment.findNavController
import com.digipod.anotherrecyclerexample.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.layout_choices,
            android.R.layout.simple_list_item_1
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerChoice.adapter = adapter
        binding.buttonFirst.setOnClickListener {
            val selection = binding.spinnerChoice.selectedItem.toString()
            val dir = FirstFragmentDirections.actionFirstFragmentToSecondFragment(selection)
            findNavController().navigate(dir)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}