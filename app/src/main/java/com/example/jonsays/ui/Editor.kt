package com.example.jonsays.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.jonsays.MainActivity
import com.example.jonsays.R
import com.example.jonsays.databinding.EditorBinding
import com.example.jonsays.other.AllPagesViewModel
import com.example.jonsays.other.Page
import com.example.jonsays.other.PageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Editor : Fragment() {

    private var _binding: EditorBinding? = null
    private val binding get() = _binding!!
    private var imageUri: Uri? = null
    private var sound: Uri = Uri.parse("android.resource://" + "com.example.jonsays" + "/raw/record_new")
    private var id : Int? = null
    private val viewModel : PageViewModel by viewModels()
    private val allViewModel: AllPagesViewModel by viewModels()
    private var sounds = mutableListOf<Uri>(sound, sound, sound, sound, sound, sound, sound, sound, sound, sound)

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
            if (it != null) {
                requireActivity().contentResolver.takePersistableUriPermission(
                    it,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
                sound = it
            } else {
                sound = Uri.parse("android.resource://" + "com.example.jonsays" + "/raw/record_new")
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = EditorBinding.inflate(inflater, container, false);

        id = arguments?.getInt("id")

        if (id != null) {
            viewModel.page.observe(viewLifecycleOwner) {
                update(it)
            }

            id?.let {
                viewModel.setId(it)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        id = arguments?.getInt("id")

        binding.pic.setOnClickListener {
            pickItemLauncher.launch(arrayOf("image/*"))
                binding.image.setImageURI(imageUri)
            }

        binding.choose1.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[0] = sound
        }

        binding.choose2.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[1] = sound
        }

        binding.choose3.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[2] = sound
        }

        binding.choose4.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[3] = sound
        }

        binding.choose5.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[4] = sound
        }

        binding.choose6.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[5] = sound
        }

        binding.choose7.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[6] = sound
        }

        binding.choose8.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[7] = sound
        }

        binding.choose9.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[8] = sound
        }

        binding.choose10.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[9] = sound
        }

        binding.done.setOnClickListener {

            if (id == null) {
                MainActivity.id += 1
                id = MainActivity.id
            }

            val page = Page(
                id!!,
                binding.name.text.toString(),
                imageUri.toString(),
                false,
                binding.btn1txt.text.toString(),
                binding.btn2txt.text.toString(),
                binding.btn3txt.text.toString(),
                binding.btn4txt.text.toString(),
                binding.btn5txt.text.toString(),
                binding.btn6txt.text.toString(),
                binding.btn7txt.text.toString(),
                binding.btn8txt.text.toString(),
                binding.btn9txt.text.toString(),
                binding.btn10txt.text.toString(),
                sounds[0].toString(),
                sounds[1].toString(),
                sounds[2].toString(),
                sounds[3].toString(),
                sounds[4].toString(),
                sounds[5].toString(),
                sounds[6].toString(),
                sounds[7].toString(),
                sounds[8].toString(),
                sounds[9].toString()
                )

            allViewModel.addPage(page)
            findNavController().navigate(R.id.action_editor_to_allPages)
        }
    }

    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

    private fun update(page: Page) {
        binding.name.text = page.title.toEditable()
        imageUri = page.image.toUri()
        binding.image.setImageURI(imageUri)
        binding.btn1txt.text = page.btn1.toEditable()
        binding.btn2txt.text = page.btn2.toEditable()
        binding.btn3txt.text = page.btn3.toEditable()
        binding.btn4txt.text = page.btn4.toEditable()
        binding.btn5txt.text = page.btn5.toEditable()
        binding.btn6txt.text = page.btn6.toEditable()
        binding.btn7txt.text = page.btn7.toEditable()
        binding.btn8txt.text = page.btn8.toEditable()
        binding.btn9txt.text = page.btn9.toEditable()
        binding.btn10txt.text = page.btn10.toEditable()
        sounds[0] = Uri.parse(page.sound1)
        sounds[1] = Uri.parse(page.sound2)
        sounds[2] = Uri.parse(page.sound3)
        sounds[3] = Uri.parse(page.sound4)
        sounds[4] = Uri.parse(page.sound5)
        sounds[5] = Uri.parse(page.sound6)
        sounds[6] = Uri.parse(page.sound7)
        sounds[7] = Uri.parse(page.sound8)
        sounds[8] = Uri.parse(page.sound9)
        sounds[9] = Uri.parse(page.sound10)
    }
}
