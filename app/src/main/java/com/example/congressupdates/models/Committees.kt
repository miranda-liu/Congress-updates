package com.example.congressupdates.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
// OLD VERSION (MAYBE)
@Parcelize
data class Committees(
    val status: String,
    val copyright: String,
    val congress: String,
    val chamber: String,
    val num_results: Int,
    val results: List<Information>
) : Parcelable{
    @Parcelize
    data class Information(
        val id: String,
        val name: String,
        val chamber: String,
        val url: String,
        val api_url: String,
        val chair: String,
        val chair_id: String,
        val chair_party: String,
        val chair_state: String,
        val chair_url: String,
        val ranking_member_id: String,
        val subcommittees: List<Subcommittees>
    ) : Parcelable{
        @Parcelize
        data class Subcommittees(
            val id: String,
            val name: String,
            val subcommittee_url: String
        ) : Parcelable
    }
}