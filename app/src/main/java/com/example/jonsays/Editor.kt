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
    private var sound: Uri = Uri.parse("android.resource://" + "com.example.jonsays" + "/raw/record_new")

    var sounds = mutableListOf<Uri>(
        Uri.parse(MainActivity.sound1),
        Uri.parse(MainActivity.sound2),
        Uri.parse(MainActivity.sound3),
        Uri.parse(MainActivity.sound4),
        Uri.parse(MainActivity.sound5),
        Uri.parse(MainActivity.sound6),
        Uri.parse(MainActivity.sound7),
        Uri.parse(MainActivity.sound8),
        Uri.parse(MainActivity.sound9),
        Uri.parse(MainActivity.sound10)
    )

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

        //fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

        binding.pic.setOnClickListener {
            pickItemLauncher.launch(arrayOf("image/*"))
                binding.image.setImageURI(imageUri)
            }

        binding.choose1.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[0] = sound
            //binding.btn1txt.text = sound.toString().toEditable()
        }

        binding.choose2.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[1] = sound
            //sound = Uri.parse("android.resource://" + "com.example.jonsays" + "/raw/record_new")
        }

        binding.choose3.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[2] = sound
            //sound = Uri.parse("android.resource://" + "com.example.jonsays" + "/raw/record_new")
        }

        binding.choose4.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[3] = sound
            //sound = Uri.parse("android.resource://" + "com.example.jonsays" + "/raw/record_new")
        }

        binding.choose5.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[4] = sound
            //sound = Uri.parse("android.resource://" + "com.example.jonsays" + "/raw/record_new")
        }

        binding.choose6.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[5] = sound
            sound = Uri.parse("android.resource://" + "com.example.jonsays" + "/raw/record_new")
        }

        binding.choose7.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[6] = sound
            //sound = Uri.parse("android.resource://" + "com.example.jonsays" + "/raw/record_new")
        }

        binding.choose8.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[7] = sound
            //sound = Uri.parse("android.resource://" + "com.example.jonsays" + "/raw/record_new")
        }

        binding.choose9.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[8] = sound
            //sound = Uri.parse("android.resource://" + "com.example.jonsays" + "/raw/record_new")
        }

        binding.choose10.setOnClickListener {
            pickAudioLauncher.launch(arrayOf("audio/*"))
            sounds[9] = sound
            //sound = Uri.parse("android.resource://" + "com.example.jonsays" + "/raw/record_new")
        }

        binding.done.setOnClickListener {
            //save edited info
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

            MainActivity.sound1 = sounds[0].toString()
            MainActivity.sound2 = sounds[1].toString()
            MainActivity.sound3 = sounds[2].toString()
            MainActivity.sound4 = sounds[3].toString()
            MainActivity.sound5 = sounds[4].toString()
            MainActivity.sound6 = sounds[5].toString()
            MainActivity.sound7 = sounds[6].toString()
            MainActivity.sound8 = sounds[7].toString()
            MainActivity.sound9 = sounds[8].toString()
            MainActivity.sound10 = sounds[9].toString()

            findNavController().navigate(R.id.action_editor_to_jon)
        }
    }
}