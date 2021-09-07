package com.sokolov.developerslife.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.sokolov.developerslife.App
import com.sokolov.developerslife.R
import com.sokolov.developerslife.contract.MainContract
import com.sokolov.developerslife.data.Gif
import com.sokolov.developerslife.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.MainView {

    private lateinit var binding: ActivityMainBinding


    @Inject
    lateinit var presenter: MainContract.MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.component.inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.selectedItemId = R.id.latest

        binding.contentNext.setOnClickListener { presenter.onNextGifClicked() }
        binding.contentPrevious.setOnClickListener { presenter.onPreviousGifClicked() }

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.latest -> {
                    presenter.onLatestCategorySelected()
                }
                R.id.top -> {
                    presenter.onTopCategorySelected()
                }
                R.id.hot -> {
                    presenter.onHotCategorySelected()
                }
            }
            true
        }
    }

    override fun onStart() {
        super.onStart()

        presenter.onViewAttached(this)
    }

    override fun onStop() {
        presenter.onViewDetached()
        super.onStop()
    }

    override fun showGif(gif: Gif) {
        Glide.with(this)
            .asGif()
            .centerCrop()
//            .placeholder(CircularProgressD)
            .load(gif.gifUrl)
            .into(binding.content)
    }

    override fun showLoadingError() {
        TODO("Not yet implemented")
    }

    override fun showLackOfGif() {
        binding.content.setImageDrawable(null)
        Snackbar.make(binding.content, R.string.lack_of_gifs, Snackbar.LENGTH_SHORT).show()
    }

    override fun enablePreviousGifButton() {
        binding.contentPrevious.isEnabled = true
    }

    override fun disablePreviousGifButton() {
        binding.contentPrevious.isEnabled = false
    }
}