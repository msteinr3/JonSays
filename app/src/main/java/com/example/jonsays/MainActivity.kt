package com.example.jonsays

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
    }
}