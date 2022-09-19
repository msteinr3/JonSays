package com.example.jonsays

import android.media.MediaPlayer
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

        //get saved button names
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
        var songs = arrayOf(R.raw.champaign)

        fun playSound(song: Int) {
            if (mp == null) {
                mp = MediaPlayer.create(requireContext(), song)
                mp!!.isLooping = true
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

        binding.editBtn.setOnClickListener {
            findNavController().navigate(R.id.action_jon_to_editor)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}