package com.example.jonsays

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jonsays.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

    }

    override fun onPause() {
        super.onPause()
        // Creating a shared pref object
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putInt("id", id)
        myEdit.apply()
    }

    override fun onResume() {
        super.onResume()
        // Fetching stored data from SharedPreference
        val sh = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        id = sh.getInt("id", 0)
    }

    companion object {
        var id = 1
    }


/*
    override fun onPause() {
        super.onPause()
        // Creating a shared pref object
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("name", name)
        myEdit.putString("image", image)

        myEdit.putString("btn1", btn1)
        myEdit.putString("btn2", btn2)
        myEdit.putString("btn3", btn3)
        myEdit.putString("btn4", btn4)
        myEdit.putString("btn5", btn5)
        myEdit.putString("btn6", btn6)
        myEdit.putString("btn7", btn7)
        myEdit.putString("btn8", btn8)
        myEdit.putString("btn9", btn9)
        myEdit.putString("btn10", btn10)

        myEdit.putString("sound1", sound1)
        myEdit.putString("sound2", sound2)
        myEdit.putString("sound3", sound3)
        myEdit.putString("sound4", sound4)
        myEdit.putString("sound5", sound5)
        myEdit.putString("sound6", sound6)
        myEdit.putString("sound7", sound7)
        myEdit.putString("sound8", sound8)
        myEdit.putString("sound9", sound9)
        myEdit.putString("sound10", sound10)

        myEdit.apply()
    }

    override fun onResume() {
        super.onResume()
        // Fetching stored data from SharedPreference
        val sh = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        name = sh.getString("name", "").toString()
        image = sh.getString("image", "").toString()

        btn1 = sh.getString("btn1", "").toString()
        btn2 = sh.getString("btn2", "").toString()
        btn3 = sh.getString("btn3", "").toString()
        btn4 = sh.getString("btn4", "").toString()
        btn5 = sh.getString("btn5", "").toString()
        btn6 = sh.getString("btn6", "").toString()
        btn7 = sh.getString("btn7", "").toString()
        btn8 = sh.getString("btn8", "").toString()
        btn9 = sh.getString("btn9", "").toString()
        btn10 = sh.getString("btn10", "").toString()

        sound1 = sh.getString("sound1", "").toString()
        sound2 = sh.getString("sound2", "").toString()
        sound3 = sh.getString("sound3", "").toString()
        sound4 = sh.getString("sound4", "").toString()
        sound5 = sh.getString("sound5", "").toString()
        sound6 = sh.getString("sound6", "").toString()
        sound7 = sh.getString("sound7", "").toString()
        sound8 = sh.getString("sound8", "").toString()
        sound9 = sh.getString("sound9", "").toString()
        sound10 = sh.getString("sound10", "").toString()
    }

    companion object {
        var name = "Jon Says"
        var image = ""

        var btn1 = "btn1"
        var btn2 = "btn2"
        var btn3 = "btn3"
        var btn4 = "btn4"
        var btn5 = "btn5"
        var btn6 = "btn6"
        var btn7 = "btn7"
        var btn8 = "btn8"
        var btn9 = "btn9"
        var btn10 = "btn10"

        var sound1 = "android.resource://" + "com.example.jonsays" + "/raw/record_new"
        var sound2 = "android.resource://" + "com.example.jonsays" + "/raw/record_new"
        var sound3 = "android.resource://" + "com.example.jonsays" + "/raw/record_new"
        var sound4 = "android.resource://" + "com.example.jonsays" + "/raw/record_new"
        var sound5 = "android.resource://" + "com.example.jonsays" + "/raw/record_new"
        var sound6 = "android.resource://" + "com.example.jonsays" + "/raw/record_new"
        var sound7 = "android.resource://" + "com.example.jonsays" + "/raw/record_new"
        var sound8 = "android.resource://" + "com.example.jonsays" + "/raw/record_new"
        var sound9 = "android.resource://" + "com.example.jonsays" + "/raw/record_new"
        var sound10 = "android.resource://" + "com.example.jonsays" + "/raw/record_new"
    }

     */
}
