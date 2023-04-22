package com.example.jonsays.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jonsays.R
import com.example.jonsays.databinding.WeightBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Weight : Fragment() {

    private var _binding: WeightBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = WeightBinding.inflate(inflater, container, false);


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.add.setOnClickListener {
            binding.listDates.text = "${binding.day.text.toString()}"
            binding.listWeights.text = "${binding.number.text.toString()}"
        }

        binding.home.setOnClickListener {
            findNavController().navigate(R.id.action_weight2_to_allPages)
        }
    }
}