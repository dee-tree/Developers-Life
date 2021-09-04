package com.sokolov.developerslive.contract

import com.sokolov.developerslive.data.Gif
import com.sokolov.developerslive.data.GifCategory

abstract class MainContract {

    interface MainPresenter <V: MainView, M: MainModel> : BaseContract.Presenter <V, M> {

        fun onLatestCategorySelected()
        fun onTopCategorySelected()
        fun onHotCategorySelected()

    }

    interface MainView : BaseContract.View {

    }

    interface MainModel : BaseContract.Model {
        fun nextGif(category: GifCategory, completeListener: CompleteListener)
        fun previousGif(category: GifCategory, completeListener: CompleteListener)
    }

    interface GifInteractor {
        fun loadGif(completeListener: CompleteListener)
    }

    interface CompleteListener {

        fun onSuccess(gif: Gif) = Unit

        fun onFailure(t: Throwable) = Unit
    }
}