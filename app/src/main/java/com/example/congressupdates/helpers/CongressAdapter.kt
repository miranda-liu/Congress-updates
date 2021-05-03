package com.example.congressupdates.helpers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.congressupdates.R
import com.example.congressupdates.models.MembersInChamberResult

class CongressAdapter(private val congressList: List<MembersInChamberResult>) : RecyclerView.Adapter<CongressAdapter.ViewHolder>() {

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

        // put something here

    }
}