package com.sokolov.developerslife.contract

import com.sokolov.developerslife.data.Gif
import com.sokolov.developerslife.data.GifCategory

abstract class MainContract {

    interface MainPresenter : BaseContract.Presenter<MainView, MainModel> {

        fun onLatestCategorySelected()
        fun onTopCategorySelected()
        fun onHotCategorySelected()

        fun onNextGifClicked()
        fun onPreviousGifClicked()

    }

    interface MainView : BaseContract.View {
        fun showGif(gif: Gif)
        fun showLoadingError()
        fun showLackOfGif()

        fun enablePreviousGifButton()
        fun disablePreviousGifButton()
    }

    interface MainModel : BaseContract.Model {
        fun currentGif(category: GifCategory, completeListener: CompleteListener)
        fun nextGif(category: GifCategory, completeListener: CompleteListener)
        fun previousGif(category: GifCategory, completeListener: CompleteListener)

        fun hasPreviousGif(category: GifCategory): Boolean
    }


    interface CompleteListener {

        fun onSuccess(gif: Gif) = Unit

        fun onFailure(t: Throwable) = Unit
    }
}