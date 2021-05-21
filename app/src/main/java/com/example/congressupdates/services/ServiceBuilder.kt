package com.example.congressupdates.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

// retrofit is a library that handles connecting to a web server, asking and formatting the data

// helps build the services with retrofit and the interface
// instantiates retrofit with OkHttp client which is needed to get the interface working

object ServiceBuilder {
    private const val URL ="https://api.propublica.org/congress/v1/" // base URL, DON'T CHANGE!!
    private const val committeeURL = "https://api.propublica.org/congress/v1/{congress}/{chamber}/committees.json" //committee URL

    //CREATE HTTP CLIENT
    private val okHttp = OkHttpClient.Builder()

    //retrofit builder
    private val builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    private val committeeBuilder = Retrofit.Builder().baseUrl(committeeURL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    //create retrofit Instance
    private val retrofit = builder.build()
    private val committeeRetrofit = committeeBuilder.build()

    //we will use this class to create an anonymous inner class function that
    //implements Country service Interface

    fun <T> buildService (serviceType :Class<T>):T{
        return retrofit.create(serviceType)
    }
    fun <T> buildService2 (serviceType :Class<T>):T{
        return committeeRetrofit.create(serviceType)
    }

}