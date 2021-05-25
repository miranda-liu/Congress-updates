package com.example.congressupdates.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.congressupdates.R
import com.example.congressupdates.models.MembersByStateResult
import kotlinx.android.synthetic.main.activity_congress_detail.*

class CongressDetailActivity : AppCompatActivity() {
    companion object{
        val EXTRA_CONGRESS = "CongressDetailActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congress_detail)

        val congressPerson = intent.getParcelableExtra<MembersByStateResult.Member>(
            EXTRA_CONGRESS)

        if(congressPerson != null){
            textView_congressDetailActivity_name.text = congressPerson.name
            textView_congressDetailActivity_role.text = "Role: " + congressPerson.role

            if(congressPerson.party == "D"){
                textView_congressDetailActivity_party.text = "Party: Democrat"
            }
            else if(congressPerson.party == "R"){
                textView_congressDetailActivity_party.text = "Party: Republican"
            }
            else{
                textView_congressDetailActivity_party.text = "Party: Other"
            }

            textView_congressDetailActivity_twitter.text = "Twitter ID: " + congressPerson.twitter_id
            textView_congressDetailActivity_facebook.text = "Facebook Account: " + congressPerson.facebook_account
            textView_congressDetailActivity_youtube.text = "Youtube Account: " + congressPerson.youtube_id
            textView_congressDetailActivity_news.text = "News: " + congressPerson.times_topics_url
        }
    }

}