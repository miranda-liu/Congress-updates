package com.example.congressupdates.services

import com.example.congressupdates.models.Committees
import retrofit2.http.GET
import retrofit2.http.Query

interface CongressService {
    @GET("")
    fun getCongressList(@Query("apiKey") apiKey : String, @Query("congress") congress : String)
    fun getChamberList(@Query("apiKey") apiKey : String, @Query("chamber") chamber : String)
    fun getCommitteeList(@Query("apiKey") apiKey : String, @Query("committees") committees: String)
}