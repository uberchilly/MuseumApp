package com.elfak.museumapp.network

import com.elfak.museumapp.model.MuseumModel
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL =
    "https://dl.dropboxusercontent.com/s/hikor9y1yyp12ez/json_example.json?dl=0" //todo: change to ngrok base url

interface ApiInterface {

    @GET("$BASE_URL/qr_code")
    suspend fun getDataFromQrCodeKey(@Query("guid") guid: String): MuseumModel
}