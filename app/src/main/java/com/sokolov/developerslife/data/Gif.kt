package com.sokolov.developerslife.data

import com.google.gson.annotations.SerializedName

data class Gif(
    @SerializedName("id") val id: Int,
    @SerializedName("description") val description: String,
    @SerializedName("votes") val votes: Int,
    @SerializedName("author") val author: String,
    @SerializedName("date") val date: String,
    @SerializedName("gifURL") val gifUrl: String,
    @SerializedName("gifSize") val gifSize: Int,
    @SerializedName("previewURL") val previewUrl: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int
)

/*
{"id":928,"description":"Сложный SQL выполненный на хорошо спроектированной БД","votes":846,"author":"Jet","date":"Apr 16, 2013 11:59:17 AM","gifURL":"http://static.devli.ru/public/images/gifs/201304/aa19ed2a-1392-40c7-8521-3b121d97b8f9.gif","gifSize":4151044,"previewURL":"https://static.devli.ru/public/images/previews/201304/de6b3679-400a-44fa-ada4-7b997dad5487.jpg","videoURL":"http://static.devli.ru/public/images/v/201304/322e1224-2751-41dc-b4e8-ceb77257d084.mp4","videoPath":"/public/images/v/201304/322e1224-2751-41dc-b4e8-ceb77257d084.mp4","videoSize":929168,"type":"gif","width":"360","height":"220","commentsCount":1,"fileSize":4151044,"canVote":false}
 */