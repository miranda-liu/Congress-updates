package com.example.congressupdates.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.congressupdates.R
import kotlinx.android.synthetic.main.activity_name_search.*

class NameSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_search)


        button_nameSearchActivity_go.setOnClickListener{
            // make call to search by name
        }
    }

}