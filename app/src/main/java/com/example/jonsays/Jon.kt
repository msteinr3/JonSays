package com.example.jonsays

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.jonsays.databinding.JonBinding

class Jon : Fragment() {

    private var _binding: JonBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = JonBinding.inflate(inflater, container, false);

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

        var mp: MediaPlayer? = null

        /*
        var sounds = mutableListOf<Uri?>(
            MainActivity.sound1.toUri(),
            MainActivity.sound2.toUri(),
            MainActivity.sound3.toUri(),
            MainActivity.sound4.toUri(),
            MainActivity.sound5.toUri(),
            MainActivity.sound6.toUri(),
            MainActivity.sound7.toUri(),
            MainActivity.sound8.toUri(),
            MainActivity.sound9.toUri(),
            MainActivity.sound10.toUri()
        )
         */

        fun playSound(song: Uri?) {
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
            playSound(MainActivity.sound1.toUri())
        }

        /*
        binding.btn2.setOnClickListener {
            playSound(sounds[1])
        }

        binding.btn3.setOnClickListener {
            playSound(sounds[2])
        }

        binding.btn4.setOnClickListener {
            playSound(sounds[3])
        }

        binding.btn5.setOnClickListener {
            playSound(sounds[4])
        }

        binding.btn6.setOnClickListener {
            playSound(sounds[5])
        }

        binding.btn7.setOnClickListener {
            playSound(sounds[6])
        }

        binding.btn8.setOnClickListener {
            playSound(sounds[7])
        }

        binding.btn9.setOnClickListener {
            playSound(sounds[8])
        }

        binding.btn10.setOnClickListener {
            playSound(sounds[9])
        }

         */

        binding.editBtn.setOnClickListener {
            findNavController().navigate(R.id.action_jon_to_editor)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}