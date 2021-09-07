package com.sokolov.developerslife.api

import com.sokolov.developerslife.data.Gif
import com.sokolov.developerslife.data.GifList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DevelopersLifeService {

    @GET("latest/{page}?json=true")
    fun getLatestGifs(@Path("page") page: Int): Call<GifList>

    @GET("top/{page}?json=true")
    fun getTopGifs(@Path("page") page: Int): Call<GifList>

    @GET("hot/{page}?json=true")
    fun getHotGifs(@Path("page") page: Int): Call<GifList>
}