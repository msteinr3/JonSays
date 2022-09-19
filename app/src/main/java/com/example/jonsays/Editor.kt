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
    private var sounds = mutableListOf<Uri>()

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

    private val pickAudioLauncher: ActivityResultLauncher<Array<String>> =
        registerForActivityResult(ActivityResultContracts.OpenDocument()) {
            //binding.image.setImageURI(it)
            if (it != null) {
                requireActivity().contentResolver.takePersistableUriPermission(
                    it,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
                sounds.add(it!!)
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = EditorBinding.inflate(inflater, container, false);

        fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

        //saved button names
        binding.name.text = MainActivity.name.toEditable()
        imageUri = MainActivity.image.toUri()
        binding.image.setImageURI(imageUri)
        binding.btn1txt.text = MainActivity.btn1.toEditable()
        binding.btn2txt.text = MainActivity.btn2.toEditable()
        binding.btn3txt.text = MainActivity.btn3.toEditable()
        binding.btn4txt.text = MainActivity.btn4.toEditable()
        binding.btn5txt.text = MainActivity.btn5.toEditable()
        binding.btn6txt.text = MainActivity.btn6.toEditable()
        binding.btn7txt.text = MainActivity.btn7.toEditable()
        binding.btn8txt.text = MainActivity.btn8.toEditable()
        binding.btn9txt.text = MainActivity.btn9.toEditable()
        binding.btn10txt.text = MainActivity.btn10.toEditable()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pic.setOnClickListener {
            pickItemLauncher.launch(arrayOf("image/*"))
                binding.image.setImageURI(imageUri)
            }

        binding.record1.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
        }

        binding.record2.setOnClickListener {

        }

        binding.choose1.setOnClickListener {

        }

        binding.choose2.setOnClickListener {

        }

        binding.done.setOnClickListener {
            //save edited button names
            MainActivity.name = binding.name.text.toString()
            MainActivity.image = imageUri.toString()
            MainActivity.btn1 = binding.btn1txt.text.toString()
            MainActivity.btn2 = binding.btn2txt.text.toString()
            MainActivity.btn3 = binding.btn3txt.text.toString()
            MainActivity.btn4 = binding.btn4txt.text.toString()
            MainActivity.btn5 = binding.btn5txt.text.toString()
            MainActivity.btn6 = binding.btn6txt.text.toString()
            MainActivity.btn7 = binding.btn7txt.text.toString()
            MainActivity.btn8 = binding.btn8txt.text.toString()
            MainActivity.btn9 = binding.btn9txt.text.toString()
            MainActivity.btn10 = binding.btn10txt.text.toString()

            findNavController().navigate(R.id.action_editor_to_jon)
        }
    }
}