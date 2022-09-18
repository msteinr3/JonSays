package com.example.jonsays

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jonsays.databinding.EditorBinding

class Editor : Fragment() {

    private var _binding: EditorBinding? = null
    private val binding get() = _binding!!
    private var imageUri: Uri? = null

    private val pickItemLauncher: ActivityResultLauncher<Array<String>> =
        registerForActivityResult(ActivityResultContracts.OpenDocument()) {
            binding.image.setImageURI(it)
            if (it != null) {
                requireActivity().contentResolver.takePersistableUriPermission(
                    it,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
            }
            imageUri = it
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = EditorBinding.inflate(inflater, container, false);

        fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

        //button names stay same in editor
        binding.titleTxt.text = arguments?.getString("title")?.toEditable()
        binding.image.setImageURI(arguments?.getString("image")?.toUri())
        binding.btn1txt.text = arguments?.getString("btn1")?.toEditable()
        binding.btn2txt.text = arguments?.getString("btn2")?.toEditable()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pic.setOnClickListener {
            pickItemLauncher.launch(arrayOf("image/*"))
                binding.image.setImageURI(imageUri)
            }

        binding.record1.setOnClickListener {

        }

        binding.record2.setOnClickListener {

        }

        binding.choose1.setOnClickListener {

        }

        binding.choose2.setOnClickListener {

        }

        binding.done.setOnClickListener {
            //send edited button names
            val bundle = bundleOf(
                "title" to binding.titleTxt.text.toString(),
                "image" to imageUri.toString(),
                "btn1" to binding.btn1txt.text.toString(),
                "btn2" to binding.btn2txt.text.toString()
            )
            findNavController().navigate(R.id.action_editor_to_jon, bundle)
        }
    }
}