package com.example.congressupdates.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.congressupdates.R
import kotlinx.android.synthetic.main.activity_location_search.*

class LocationSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_search)


        button_locationSearchActivity_go.setOnClickListener{
            // make the call to search by location

            // when search is clicked, hide the search button
            // show recycler view w the results
            // do the query, add results to recycler view
            // if nothing is found --> toast that nothing can be found

            // when you click back button
            // override on back pressed and if recycler view is visible, hide recycler view
            // and show the button and editText again
            // if button is already visible, super.onbackpress (normal way of going back to last activity)
        }
    }
}