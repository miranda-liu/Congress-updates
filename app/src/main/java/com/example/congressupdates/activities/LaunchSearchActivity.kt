package com.example.congressupdates.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.congressupdates.R
import kotlinx.android.synthetic.main.activity_launch_search.*

class LaunchSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_search)

        button_launchSearchActivity_locationSearch.setOnClickListener{
            val locationSearchIntent = Intent(this, LocationSearchActivity::class.java)
            startActivity(locationSearchIntent)
        }

        button_launchSearchActivity_nameSearch.setOnClickListener{
            val nameSearchIntent = Intent(this, NameSearchActivity::class.java)
            startActivity(nameSearchIntent)
        }
    }

}