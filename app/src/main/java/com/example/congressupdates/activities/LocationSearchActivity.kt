package com.example.congressupdates.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.congressupdates.R
import com.example.congressupdates.helpers.CongressAdapter
import com.example.congressupdates.models.MembersByStateResult
import com.example.congressupdates.models.MembersInChamberResult
import com.example.congressupdates.services.CongressService
import com.example.congressupdates.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_location_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationSearchActivity : AppCompatActivity() {
    val TAG = "LocationSearchActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_search)

        member_recycler.visibility = View.GONE

        button_locationSearchActivity_go.setOnClickListener{
            // make the call to search by location
            val destinationService = ServiceBuilder.buildService(CongressService::class.java)
            val locationSearchString = editText_locationSearchActivity_location.text.toString().trim()
            val requestCall = destinationService.getSenateListbyLocation(locationSearchString)

            // when search is clicked, hide the search button
            button_locationSearchActivity_go.visibility = View.GONE
            editText_locationSearchActivity_location.visibility = View.GONE

            // show recycler view w the results
            // do the query, add results to recycler view
            // if nothing is found --> toast that nothing can be found

            // when you click back button
            // override on back pressed and if recycler view is visible, hide recycler view
            // and show the button and editText again
            // if button is already visible, super.onbackpress (normal way of going back to last activity)

            requestCall.enqueue(object : Callback<MembersByStateResult> {
                override fun onFailure(call: Call<MembersByStateResult>, t: Throwable) {
                    Log.d(TAG, "onResponse: " + t.message) // t is the throwable --> data type for a type of error
                }

                override fun onResponse(call: Call<MembersByStateResult>, response: Response<MembersByStateResult>) {
                    member_recycler.visibility = View.VISIBLE
                    Log.d(TAG, "onResponse: " + response.body())
                    if (response.isSuccessful) {
                        val memberList = response.body()?.results?: emptyList<MembersByStateResult.Member>() // make emptyList of MovieResult if no response from API
                        Log.d(TAG, "onResponse: $memberList")
                        // Log.d("Response", "movieList size" + movieList.totalResults)
                        member_recycler.apply {
                            setHasFixedSize(true)
                            layoutManager = LinearLayoutManager(this@LocationSearchActivity) // can't just use this because you're in inner class
                            adapter = CongressAdapter(memberList)
                        }
                    }
                }
            })

        }
    }

    override fun onBackPressed() {
        if (member_recycler.visibility == View.VISIBLE)
        super.onBackPressed()
    }
}