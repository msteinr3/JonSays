package com.example.jonsays.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jonsays.other.Page
import com.example.jonsays.other.PageAdapter
import com.example.jonsays.other.PageViewModel
import com.example.jonsays.R
import com.example.jonsays.databinding.AllPagesBinding
import com.example.jonsays.other.AllPagesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllPages : Fragment(), PageAdapter.PageItemListener {

    private var _binding: AllPagesBinding? = null
    private val binding get() = _binding!!
    private val viewModel : PageViewModel by viewModels()
    private val allViewModel: AllPagesViewModel by viewModels()
    private lateinit var adapter: PageAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AllPagesBinding.inflate(inflater, container, false);


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.newPage.setOnClickListener {
            findNavController().navigate(R.id.action_allPages_to_editor)
        }

        adapter = PageAdapter(this)
        binding.recycler.layoutManager =
            LinearLayoutManager(requireContext())
        binding.recycler.adapter = adapter

        allViewModel.pages?.observe(viewLifecycleOwner) {
            adapter.setPages(it)
            binding.number.text = adapter.itemCount.toString()
        }
    }

    override fun onPageClick(pageId: Int) {
        findNavController().navigate(R.id.action_allPages_to_jon, bundleOf("id" to pageId))
    }

    override fun onPageLongClick(page: Page) {
        viewModel.page.observe(viewLifecycleOwner) {
        }
        viewModel.setId(page.id)
        page.favorite = page.favorite != true

        viewModel.update(page)
    }
}