package com.sokolov.developerslife.presenter

import com.sokolov.developerslife.contract.MainContract
import com.sokolov.developerslife.data.Gif
import com.sokolov.developerslife.data.GifCategory
import com.sokolov.developerslife.data.LackOfGifThrowable

class MainPresenterImpl(
    override val model: MainContract.MainModel
) : MainContract.MainPresenter, MainContract.CompleteListener {

    val defaultGifCategory = GifCategory.LATEST

    var currentGifCategory = defaultGifCategory
    private set

    override var view: MainContract.MainView? = null

    override fun onViewAttached(v: MainContract.MainView) {
        super.onViewAttached(v)

        updatePreviousGifButtonState()

        loadCurrentGif()
    }

    private fun updatePreviousGifButtonState() {
        if (model.hasPreviousGif(currentGifCategory))
            view?.enablePreviousGifButton()
        else
            view?.disablePreviousGifButton()
    }

    private fun loadCurrentGif() {
        model.currentGif(currentGifCategory, object : MainContract.CompleteListener {
            override fun onSuccess(gif: Gif) {
                view?.showGif(gif)
            }

            override fun onFailure(t: Throwable) {
                if (t is LackOfGifThrowable)
                    view?.showLackOfGif()
                else
                    view?.showLoadingError()
            }
        })
    }

    override fun onLatestCategorySelected() {
        currentGifCategory = GifCategory.LATEST
        updatePreviousGifButtonState()
        loadCurrentGif()
    }

    override fun onTopCategorySelected() {
        currentGifCategory = GifCategory.TOP
        updatePreviousGifButtonState()
        loadCurrentGif()
    }

    override fun onHotCategorySelected() {
        currentGifCategory = GifCategory.HOT
        updatePreviousGifButtonState()
        loadCurrentGif()
    }

    override fun onNextGifClicked() {
        model.nextGif(currentGifCategory, object : MainContract.CompleteListener {
            override fun onSuccess(gif: Gif) {
                view?.showGif(gif)

                updatePreviousGifButtonState()
            }

            override fun onFailure(t: Throwable) {
                if (t is LackOfGifThrowable)
                    view?.showLackOfGif()
                else
                    view?.showLoadingError()
            }
        })

    }

    override fun onPreviousGifClicked() {
        model.previousGif(currentGifCategory, object : MainContract.CompleteListener {
            override fun onSuccess(gif: Gif) {
                view?.showGif(gif)

                updatePreviousGifButtonState()
            }
        })
    }
}