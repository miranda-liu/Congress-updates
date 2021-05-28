package com.example.congressupdates.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Committee(
    val copyright: String,
    val results: List<Result>,
    val status: String
) : Parcelable {
    @Parcelize
    data class Result(
        val chamber: String,
        val committees: List<Committee>,
        val congress: String,
        val num_results: Int
    ): Parcelable {
        @Parcelize
        data class Committee(
            val api_uri: String,
            val chair: String,
            val chair_id: String,
            val chair_party: String,
            val chair_state: String,
            val chair_uri: String,
            val chamber: String,
            val id: String,
            val name: String,
            val ranking_member_id: String,
            val subcommittees: List<Subcommittee>,
            val url: String
        ):Parcelable {
            @Parcelize
            data class Subcommittee(
                val api_uri: String,
                val id: String,
                val name: String
            ):Parcelable
        }
    }
}