package com.example.congressupdates.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MembersInChamberResult(
    val copyright: String,
    val results: List<Result>,
    val status: String
): Parcelable {
    @Parcelize
    data class Result(
        val chamber: String,
        val congress: String,
        val members: List<Member>,
        val num_results: Int,
        val offset: Int
    ):Parcelable {
        @Parcelize
        data class Member(
            val api_uri: String,
            val contact_form: String,
            val cook_pvi: String?, // how much a district leans to ____ party
            val crp_id: String,
            val cspan_id: String,
            val date_of_birth: String,
            val dw_nominate: Double,
            val facebook_account: String,
            val fax: String,
            val fec_candidate_id: String,
            val first_name: String,
            val gender: String,
            val google_entity_id: String,
            val govtrack_id: String,
            val icpsr_id: String,
            val id: String,
            val ideal_point: String?,
            val in_office: Boolean,
            val last_name: String,
            val last_updated: String,
            val leadership_role: String?,
            val lis_id: String,
            val middle_name: String?,
            val missed_votes: Int,
            val missed_votes_pct: Double,
            val next_election: String,
            val ocd_id: String,
            val office: String,
            val party: String,
            val phone: String,
            val rss_url: String,
            val senate_class: String,
            val seniority: String,
            val short_title: String,
            val state: String,
            val state_rank: String,
            val suffix: String?,
            val title: String,
            val total_present: Int,
            val total_votes: Int,
            val twitter_account: String,
            val url: String,
            val votes_against_party_pct: Double,
            val votes_with_party_pct: Double,
            val votesmart_id: String,
            val youtube_account: String
        ): Parcelable
    }
}