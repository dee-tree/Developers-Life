package com.sokolov.developerslive.api

import com.sokolov.developerslive.data.Gif
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DevelopersLifeService {

    @GET("latest/{page}?json=true")
    fun getLatestGifs(@Path("page") page: Int): Call<List<Gif>>

    @GET("top/{page}?json=true")
    fun getTopGifs(@Path("page") page: Int): Call<List<Gif>>

    @GET("hot/{page}?json=true")
    fun getHotGifs(@Path("page") page: Int): Call<List<Gif>>
}