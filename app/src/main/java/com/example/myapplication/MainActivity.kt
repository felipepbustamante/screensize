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


    fun detectDevice(view: View) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val displayMetrics = windowManager.currentWindowMetrics
            val size = displayMetrics.bounds
            binding.textView.text = size.bottom.toString()
            binding.textView2.text = size.right.toString()
        } else {
            // What is the orientation?
            val display = windowManager.defaultDisplay
            binding.textView.text = "${display.rotation}"

            // What is the resolution?
            var xy = Point()
            display.getSize(xy)
            binding.textView2.text = "${xy.x}x${xy.y}"
        }

    }

}