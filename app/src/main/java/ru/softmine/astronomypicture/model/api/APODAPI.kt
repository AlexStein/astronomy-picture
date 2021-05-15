package ru.softmine.astronomypicture.model.api

import ru.softmine.astronomypicture.model.data.APODResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APODAPI {

    @GET("planetary/apod")
    fun getPictureOfTheDay(@Query("api_key") apiKey: String): Call<APODResponseData>

    @GET("planetary/apod")
    fun getPictureByDate(
        @Query("api_key") apiKey: String,
        @Query("date") date: String
    ): Call<APODResponseData>
}
