package com.sokolov.developerslive.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.sokolov.developerslive.R
import com.sokolov.developerslive.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.selectedItemId = R.id.latest
    }

    override fun onStart() {
        super.onStart()

        Glide.with(this)
            .asGif()
            .centerCrop()
            .load("http://developerslife.ru/latest/1?json=true\n")
            .into(binding.content)
    }
}