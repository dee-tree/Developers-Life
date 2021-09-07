package com.sokolov.developerslife.data

import com.google.gson.annotations.SerializedName

data class GifList(@SerializedName("result") val gifs: List<Gif>) {
}