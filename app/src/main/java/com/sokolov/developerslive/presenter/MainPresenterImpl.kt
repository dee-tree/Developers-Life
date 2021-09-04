package com.sokolov.developerslive.presenter

import com.sokolov.developerslive.contract.MainContract

class MainPresenterImpl(
    override var view: MainContract.MainView?,
    override val model: MainContract.MainModel
) : MainContract.MainPresenter <MainContract.MainView, MainContract.MainModel> {
    override fun onLatestCategorySelected() {
        TODO("Not yet implemented")
    }

    override fun onTopCategorySelected() {
        TODO("Not yet implemented")
    }

    override fun onHotCategorySelected() {
        TODO("Not yet implemented")
    }
}