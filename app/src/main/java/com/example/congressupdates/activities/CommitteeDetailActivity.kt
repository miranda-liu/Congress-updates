package com.example.congressupdates.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.congressupdates.R
import com.example.congressupdates.models.Committees
import kotlinx.android.synthetic.main.activity_committee_detail.*
import kotlinx.android.synthetic.main.activity_congress_detail.*

class CommitteeDetailActivity : AppCompatActivity() {
    companion object {
        val EXTRA_COMMITTEE = "CommitteeDetailActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_committee_detail)

        val committee = intent.getParcelableExtra<Committees.Information>(
            EXTRA_COMMITTEE
        )

        if (committee != null) {
            textView_committeeDetailActivity_name.text = committee.name
            textView_committeeDetailActivity_chair.text = "Chair: " + committee.chair
            textView_committeeDetailActivity_chamber.text = "Chamber " + committee.chamber
            textView_committeeDetailActivity_subcommittees.text = committee.subcommittees.toString()

            if (committee.chair_party == "D") {
                textView_congressDetailActivity_party.text = "Party: Democrat"
            } else if (committee.chair_party == "R") {
                textView_congressDetailActivity_party.text = "Party: Republican"
            } else {
                textView_congressDetailActivity_party.text = "Party: Other"
            }

        }
    }
}