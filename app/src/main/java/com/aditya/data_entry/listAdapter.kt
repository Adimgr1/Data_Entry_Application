package com.aditya.data_entry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class listAdapter(private val listOfContact:List<item_content>):RecyclerView.Adapter<listAdapter.itemViewHolder>() {
    class itemViewHolder(view : View):RecyclerView.ViewHolder(view){
        val img :ImageView= view.findViewById(R.id.dp)
        val name : TextView = view.findViewById(R.id.txt1)
        val number: TextView= view.findViewById(R.id.txt2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.secondary,parent, false)
        return itemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfContact.size
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.img.setImageURI(listOfContact[position].img)
        holder.name.text=(listOfContact[position].txt1)
        holder.number.text=(listOfContact[position].txt2)

    }
}