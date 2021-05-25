package com.example.congressupdates.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MembersByStateResult(
    val copyright: String,
    val results: List<Member>,
    val status: String
) : Parcelable{
    @Parcelize
    data class Member(
        val id: String?,
        val name: String?,
        val first_name: String?,
        val middle_name: String?,
        val last_name: String?,
        val suffix: String?,
        val role: String?,
        val gender: String?,
        val party: String?,
        val times_topics_url: String?,
        val twitter_id: String?,
        val facebook_account: String?,
        val youtube_id: String?,
        val seniority: String?,
        val next_election: String?,
        val api_uri: String?
    ) : Parcelable
}