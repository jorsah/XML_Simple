package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class Adapter(private var itemList:MutableList<Item>):
    RecyclerView.Adapter<Adapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        val listItem=itemList[position]
        holder.bind(listItem)

        holder.name.text =listItem.name
        holder.price.text = listItem.price.toString()
        holder.description.text = listItem.description
    }

    override fun getItemCount(): Int = itemList.size

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name: TextView =itemView.dish_name
        val price:TextView = itemView.price
        val description : TextView = itemView.description

        fun bind(listItem:Item){

        }
    }

    fun setItemList(list:MutableList<Item>){
        itemList = list
        notifyDataSetChanged()
    }
}