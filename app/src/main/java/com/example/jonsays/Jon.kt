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

        //get info from editor
        binding.title.text = arguments?.getString("title")
        var pic = arguments?.getString("image")?.toUri()
        binding.image.setImageURI(pic)
        binding.btn1.text = arguments?.getString("btn1")
        binding.btn2.text = arguments?.getString("btn2")
        binding.btn3.text = arguments?.getString("btn3")
        binding.btn4.text = arguments?.getString("btn4")
        binding.btn5.text = arguments?.getString("btn5")
        binding.btn6.text = arguments?.getString("btn6")
        binding.btn7.text = arguments?.getString("btn7")
        binding.btn8.text = arguments?.getString("btn8")
        binding.btn9.text = arguments?.getString("btn9")
        binding.btn10.text = arguments?.getString("btn10")

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
            //keep names of buttons the same
            val bundle = bundleOf(
                "title" to binding.title.text,
                "image" to pic.toString(),
                "btn1" to binding.btn1.text,
                "btn2" to binding.btn2.text,
                "btn3" to binding.btn3.text,
                "btn4" to binding.btn4.text,
                "btn5" to binding.btn5.text,
                "btn6" to binding.btn6.text,
                "btn7" to binding.btn7.text,
                "btn8" to binding.btn8.text,
                "btn9" to binding.btn9.text,
                "btn10" to binding.btn10.text
            )
            findNavController().navigate(R.id.action_jon_to_editor, bundle)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}