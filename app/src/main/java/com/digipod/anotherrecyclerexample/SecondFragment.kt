package com.digipod.anotherrecyclerexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.digipod.anotherrecyclerexample.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SecondFragmentArgs.fromBundle(requireArguments()).selection.let {
            binding.tvSelection.text = it
            binding.rvPlanets.layoutManager = when(it) {
                "Horizontal" -> LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                "Grid" -> GridLayoutManager(requireContext(), 2)
                "Staggered" -> StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                else -> LinearLayoutManager(requireContext())
            }
            binding.rvPlanets.adapter = PlanetAdapter(requireActivity(), resources.getStringArray(R.array.planets))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}