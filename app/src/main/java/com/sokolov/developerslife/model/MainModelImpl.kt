package com.sokolov.developerslife.model

import com.sokolov.developerslife.api.DevelopersLifeService
import com.sokolov.developerslife.contract.MainContract
import com.sokolov.developerslife.data.Gif
import com.sokolov.developerslife.data.GifCategory
import com.sokolov.developerslife.data.GifList
import com.sokolov.developerslife.data.LackOfGifThrowable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainModelImpl(val gifService: DevelopersLifeService) : MainContract.MainModel {

    val gifs = mutableListOf<Pair<GifCategory, Gif>>()

    override fun currentGif(
        category: GifCategory,
        completeListener: MainContract.CompleteListener
    ) {

        gifs.lastOrNull { it.first == category }?.let {
            completeListener.onSuccess(it.second)
        } ?: nextGif(category, completeListener)

    }

    override fun nextGif(category: GifCategory, completeListener: MainContract.CompleteListener) {
        loadGifsPageByCategory(category).enqueue(object : Callback<GifList> {
            override fun onResponse(call: Call<GifList>, response: Response<GifList>) {
                if (response.body() == null) completeListener.onFailure(Throwable("Unknown error"))
                else response.body()!!.gifs.firstOrNull()?.let { gifs.add(category to it); completeListener.onSuccess(it) }
                    ?: completeListener.onFailure(LackOfGifThrowable("Lack of GIFs in $category"))
            }

            override fun onFailure(call: Call<GifList>, t: Throwable) {
                completeListener.onFailure(t)
            }
        })
    }

    override fun previousGif(
        category: GifCategory,
        completeListener: MainContract.CompleteListener
    ) {
        TODO("Not yet implemented")
    }

    override fun hasPreviousGif(category: GifCategory): Boolean =
        gifs.filter { it.first == category }.count() > 1

    private fun loadGifsPageByCategory(category: GifCategory): Call<GifList> = when (category) {
        GifCategory.LATEST -> gifService.getLatestGifs(latestGifsPageID++)
        GifCategory.TOP -> gifService.getTopGifs(topGifsPageID++)
        GifCategory.HOT -> gifService.getHotGifs(hotGifsPageID++)
    }

    private var latestGifsPageID = 0
    private var topGifsPageID = 0
    private var hotGifsPageID = 0
}