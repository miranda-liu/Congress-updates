package com.example.congressupdates.helpers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.congressupdates.R
import com.example.congressupdates.models.MembersInChamberResult
import kotlinx.android.synthetic.main.congress_item.view.*

class CongressAdapter(private val congressList: List<MembersInChamberResult.Result.Member>) : RecyclerView.Adapter<CongressAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.congress_item,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {

        return congressList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${congressList.size} ")


        return holder.bind(congressList[position])

    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        // define binding function
        fun bind (congressPerson: MembersInChamberResult.Result.Member) {
            itemView.textView_Congress.text = congressPerson.first_name + " " + congressPerson.last_name
            itemView.textView_Email.text = congressPerson.phone + " " + congressPerson.facebook_account
        }

    }
}