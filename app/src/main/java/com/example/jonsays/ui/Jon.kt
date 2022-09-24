package com.example.jonsays.ui

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.jonsays.MainActivity
import com.example.jonsays.other.PageViewModel
import com.example.jonsays.R
import com.example.jonsays.databinding.JonBinding
import com.example.jonsays.other.Page
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Jon : Fragment() {

    private var _binding: JonBinding? = null
    private val binding get() = _binding!!
    private var id : Int? = null
    private val viewModel : PageViewModel by viewModels()
    private var sound: Uri = Uri.parse("android.resource://" + "com.example.jonsays" + "/raw/record_new")
    private var sounds = mutableListOf<Uri>(sound, sound, sound, sound, sound, sound, sound, sound, sound, sound)
    private var mp: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = JonBinding.inflate(inflater, container, false);

        id = arguments?.getInt("id")!!

        viewModel.page.observe(viewLifecycleOwner) {
            update(it)
        }

        id?.let {
            viewModel.setId(it)
        }

        fun playSound(song: Uri) {
            if (mp == null) {
                mp = MediaPlayer.create(requireContext(), song)
                mp!!.isLooping = false
                mp!!.start()
            } else mp!!.start()
        }

        fun pauseSound() {
            if (mp?.isPlaying == true) mp?.pause()
        }

        fun stopSound() {
            if (mp != null) {
                mp!!.stop()
                mp!!.release()
                mp = null
            }
        }

        binding.btn1.setOnClickListener {
            stopSound()
            playSound(sounds[0])
        }

        binding.btn2.setOnClickListener {
            stopSound()
            playSound(sounds[1])
        }

        binding.btn3.setOnClickListener {
            stopSound()
            playSound(sounds[2])
        }

        binding.btn4.setOnClickListener {
            stopSound()
            playSound(sounds[3])
        }

        binding.btn5.setOnClickListener {
            stopSound()
            playSound(sounds[4])
        }

        binding.btn6.setOnClickListener {
            stopSound()
            playSound(sounds[5])
        }

        binding.btn7.setOnClickListener {
            stopSound()
            playSound(sounds[6])
        }

        binding.btn8.setOnClickListener {
            stopSound()
            playSound(sounds[7])
        }

        binding.btn9.setOnClickListener {
            stopSound()
            playSound(sounds[8])
        }

        binding.btn10.setOnClickListener {
            stopSound()
            playSound(sounds[9])
        }

        binding.editBtn.setOnClickListener {
            findNavController().navigate(R.id.action_jon_to_editor, bundleOf("id" to id))
        }

        binding.home.setOnClickListener {
            findNavController().navigate(R.id.action_jon_to_allPages)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

    private fun update(page: Page) {
        binding.title.text = page.title.toEditable()
        binding.image.setImageURI(page.image.toUri())
        binding.btn1.text = page.btn1.toEditable()
        binding.btn2.text = page.btn2.toEditable()
        binding.btn3.text = page.btn3.toEditable()
        binding.btn4.text = page.btn4.toEditable()
        binding.btn5.text = page.btn5.toEditable()
        binding.btn6.text = page.btn6.toEditable()
        binding.btn7.text = page.btn7.toEditable()
        binding.btn8.text = page.btn8.toEditable()
        binding.btn9.text = page.btn9.toEditable()
        binding.btn10.text = page.btn10.toEditable()
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

/*
//get saved info
binding.title.text = MainActivity.name
var pic = MainActivity.image.toUri()
binding.image.setImageURI(pic)

binding.btn1.text = MainActivity.btn1
binding.btn2.text = MainActivity.btn2
binding.btn3.text = MainActivity.btn3
binding.btn4.text = MainActivity.btn4
binding.btn5.text = MainActivity.btn5
binding.btn6.text = MainActivity.btn6
binding.btn7.text = MainActivity.btn7
binding.btn8.text = MainActivity.btn8
binding.btn9.text = MainActivity.btn9
binding.btn10.text = MainActivity.btn10

 */
