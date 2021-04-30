package com.example.congressupdates.services

import retrofit2.http.GET
import retrofit2.http.Query

interface CongressService {
    @GET("")
    fun getCongressList(@Query("apiKey") apiKey : String, @Query("congress") congress : String)
    fun getChamberList(@Query("apiKey") apiKey : String, @Query("chamber") chamber : String)
}