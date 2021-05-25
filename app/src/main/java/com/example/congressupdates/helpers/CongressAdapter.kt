package com.example.congressupdates.helpers

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.congressupdates.R
import com.example.congressupdates.activities.CongressDetailActivity
import com.example.congressupdates.models.MembersByStateResult
import kotlinx.android.synthetic.main.congress_item.view.*

class CongressAdapter(private val congressList: List<MembersByStateResult.Member>) : RecyclerView.Adapter<CongressAdapter.ViewHolder>() {

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
        fun bind (congressPerson: MembersByStateResult.Member) {
            // this is the preview, when you click on it it brings you to CongressDetailActivity
            itemView.textView_congressItem_name.text = congressPerson.first_name + " " + congressPerson.last_name

            itemView.setOnClickListener{
                val itemViewIntent = Intent(itemView.context, CongressDetailActivity::class.java)
                itemViewIntent.putExtra(CongressDetailActivity.EXTRA_CONGRESS, congressPerson)
                itemView.context.startActivity(itemViewIntent)
            }

        }

    }
}