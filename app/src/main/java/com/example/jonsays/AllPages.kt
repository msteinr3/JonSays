package com.example.jonsays

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.jonsays.databinding.AllPagesBinding

class AllPages : Fragment() {

    private var _binding: AllPagesBinding? = null
    private val binding get() = _binding!!
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


    }
}


        /*
        allViewModel.recipes.observe(viewLifecycleOwner) {
            when(it.status) {
                is Loading -> binding.progressBar.visibility = View.VISIBLE

                is Success -> {
                    binding.progressBar.visibility = View.GONE
                    adapter.setRecipes(it.status.data!!)
                }

                is Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(),it.status.message, Toast.LENGTH_LONG).show()
                }
                else -> {}
            }
        }



    }

    override fun onRecipeClick(recipeId: Int) {
        findNavController().navigate(
            R.id.action_allPages_to_jon,
            bundleOf("id" to recipeId)
        )
    }

    override fun onRecipeLongClick(page: Page) {
        viewModel.recipe.observe(viewLifecycleOwner) {
        }
        viewModel.setId(recipe.id)
        recipe.favorite = recipe.favorite != true

        viewModel.update(recipe)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

         */
