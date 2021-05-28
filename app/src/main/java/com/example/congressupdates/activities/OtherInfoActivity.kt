package com.example.congressupdates.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.congressupdates.R
import com.example.congressupdates.helpers.CommitteeAdapter
import com.example.congressupdates.models.Committee
import com.example.congressupdates.models.Committees
import com.example.congressupdates.services.CongressService
import com.example.congressupdates.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_location_search.*
import kotlinx.android.synthetic.main.activity_other_info.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OtherInfoActivity : AppCompatActivity() {

    val TAG = "OtherInfoActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_info)

        committee_recycler.visibility = View.GONE

        button_otherInfoActivity_committees.setOnClickListener {
            // make the call to create a list of all committees
            val destinationService = ServiceBuilder.buildService(CongressService::class.java)
            // val chamberRequestString = "senate"
            val requestCall = destinationService.getCommitteesList()

            // when committees is clicked, hide the all buttons
            button_otherInfoActivity_house.visibility = View.GONE
            button_otherInfoActivity_senate.visibility =  View.GONE
            button_otherInfoActivity_committees.visibility = View.GONE

            // show recycler view w the results
            // do the query, add results to recycler view
            // if nothing is found --> toast that nothing can be found

            // when you click back button
            // override on back pressed and if recycler view is visible, hide recycler view
            // and show the button and editText again
            // if button is already visible, super.onbackpress (normal way of going back to last activity)

            requestCall.enqueue(object : Callback<Committee> {
                override fun onFailure(call: Call<Committee>, t: Throwable) {
                    Log.d(TAG, "onFailure: " + t.message) // t is the throwable --> data type for a type of error
                }

                override fun onResponse(call: Call<Committee>, response: Response<Committee>) {
                    committee_recycler.visibility = View.VISIBLE
                    Log.d(TAG, "onResponse: " + response.body())
                    if (response.isSuccessful) {
                        val committeeList = response.body()?.results?: emptyList<Committee.Result>() // make emptyList of MovieResult if no response from API
                        Log.d(TAG, "onResponse: $committeeList")
                        // Log.d("Response", "movieList size" + movieList.totalResults)
                        committee_recycler.apply {
                            setHasFixedSize(true)
                            layoutManager = LinearLayoutManager(this@OtherInfoActivity) // can't just use this because you're in inner class
                            adapter = CommitteeAdapter(committeeList)
                        }
                    }
                }
            })

        }
    }

    override fun onBackPressed() {
        if (committee_recycler.visibility == View.VISIBLE)
            super.onBackPressed()
    }



}