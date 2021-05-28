package com.example.congressupdates.services

import com.example.congressupdates.helpers.Credentials
import com.example.congressupdates.models.Committees
import com.example.congressupdates.models.MembersByStateResult
import com.example.congressupdates.models.MembersInChamberResult
import retrofit2.Call
import retrofit2.http.*

interface CongressService {
//    @GET("{congress}/{chamber}/members.json")
//    @Headers("X-API-Key: ${Credentials.apiKey}")
//    fun getCongressList(@Query("congress") congress : String)

//    @GET("")
//    fun getChamberList(@Query("apiKey") apiKey : String, @Query("chamber") chamber : String)

//    @GET("")
//    fun getCommitteeList(@Query("apiKey") apiKey : String, @Query("committees") committees: String)

    @GET("members/senate/{state}/current.json")
    @Headers("X-API-Key: ${Credentials.apiKey}")
    fun getSenateListbyLocation(@Path("state") state : String) : Call<MembersByStateResult>

    @GET("congress/v1/117/{chamber}/committees.json")
    @Headers("X-API-Key: ${Credentials.apiKey}")
    // chamber can be house, senate, or joint
    fun getCommitteesList(@Path("chamber") chamber : String) : Call<Committees>

    @GET("117/{chamber}/members.json")
    @Headers("X-API-Key: ${Credentials.apiKey}")
    fun getCongressListbyName(@Path("congress") congress : String) : Call<MembersInChamberResult>

}