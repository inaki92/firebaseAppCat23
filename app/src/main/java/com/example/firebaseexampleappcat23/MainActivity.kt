package com.example.firebaseexampleappcat23

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebaseexampleappcat23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // setting the view binding
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // passing the root layout from view binding
        setContentView(binding.root)

        binding.serviceStart.setOnClickListener {
            Intent(baseContext, FirstService::class.java).apply {
                putExtra("MY_VALUE", 10)
                putExtra("MY_VALUE2", "This is a started service")
                startService(this)
            }
        }
    }
}