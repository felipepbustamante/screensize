package com.example.myapplication

import android.graphics.Point
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        binding.button.text = "Botoon"
        binding.textView.text = "Hola1"
        binding.textView2.text = "Hola2"
        setContentView(view)

    }

    @RequiresApi(Build.VERSION_CODES.R)
    fun detectDevice(view: View) {

        val displayMetrics = windowManager.currentWindowMetrics
        val size = displayMetrics.bounds
        binding.textView.text = size.bottom.toString()
        binding.textView2.text = size.right.toString()



    }

}