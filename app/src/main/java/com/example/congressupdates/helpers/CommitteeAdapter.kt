package com.example.congressupdates.helpers

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.congressupdates.R
import com.example.congressupdates.activities.CommitteeDetailActivity
import com.example.congressupdates.models.Committees
import kotlinx.android.synthetic.main.activity_committee_item.view.*

class CommitteeAdapter(private val committeeList: List<Committees.Information>) : RecyclerView.Adapter<CommitteeAdapter.ViewHolder>(){


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            val view  = LayoutInflater.from(parent.context).inflate(R.layout.activity_committee_item,parent,false)
            return ViewHolder(view)
        }


        override fun getItemCount(): Int {

            return committeeList.size
        }


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            Log.d("Response", "List Count :${committeeList.size} ")


            return holder.bind(committeeList[position])

        }
        class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

            // define binding function
            fun bind (committeeGroup: Committees.Information) {
                // this is the preview, when you click on it it brings you to CongressDetailActivity
                itemView.textView_committeeItem_name.text = committeeGroup.name

                itemView.setOnClickListener{
                    val itemViewIntent = Intent(itemView.context, CommitteeDetailActivity::class.java)
                    itemViewIntent.putExtra(CommitteeDetailActivity.EXTRA_COMMITTEE, committeeGroup)
                    itemView.context.startActivity(itemViewIntent)
                }

            }

        }
}