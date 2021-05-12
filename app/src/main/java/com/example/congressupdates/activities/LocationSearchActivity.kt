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
        }
    }
}