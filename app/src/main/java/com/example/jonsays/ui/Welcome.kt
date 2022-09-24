package com.example.jonsays.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.jonsays.R
import com.example.jonsays.databinding.WelcomeBinding
import com.example.jonsays.other.AllPagesViewModel
import com.example.jonsays.other.Page
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Welcome : Fragment() {

    private var _binding: WelcomeBinding? = null
    private val binding get() = _binding!!
    private val allViewModel: AllPagesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = WelcomeBinding.inflate(inflater, container, false);


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*
        val page = Page(
            0,
            "title",
            "android.resource://" + "com.example.jonsays" + "/drawable/jon",
            false,
            "button1",
            "button2",
            "button3",
            "button4",
            "button5",
            "button6",
            "button7",
            "button8",
            "button9",
            "button10",
            "android.resource://" + "com.example.jonsays" + "/raw/record_new",
            "android.resource://" + "com.example.jonsays" + "/raw/record_new",
            "android.resource://" + "com.example.jonsays" + "/raw/record_new",
            "android.resource://" + "com.example.jonsays" + "/raw/record_new",
            "android.resource://" + "com.example.jonsays" + "/raw/record_new",
            "android.resource://" + "com.example.jonsays" + "/raw/record_new",
            "android.resource://" + "com.example.jonsays" + "/raw/record_new",
            "android.resource://" + "com.example.jonsays" + "/raw/record_new",
            "android.resource://" + "com.example.jonsays" + "/raw/record_new",
            "android.resource://" + "com.example.jonsays" + "/raw/record_new"
        )

        allViewModel.addPage(page)

 */

        binding.start.setOnClickListener {
            findNavController().navigate(R.id.action_welcome_to_allPages)
        }
    }
}