package com.example.tugas3_20411019

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter (private val namaLiast : ArrayList<ItemData>):RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    class MyViewHolder(itemData: View) : RecyclerView.ViewHolder (itemData) {
        val gambar: ImageView = itemData.findViewById(R.id.ImageView)
        val nama: TextView = itemData.findViewById(R.id.TextView1)
        val asal: TextView = itemData.findViewById(R.id.TextView2)


    }

    override fun onCreateViewHolder(parent:  ViewGroup, viewType: Int): MyViewHolder {
        val itemData = LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent, false)
        return MyViewHolder((itemData))
    }

    override fun getItemCount(): Int = namaLiast.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = namaLiast[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.nama.text = currentItem.nama
        holder.asal.text = currentItem.asal
    }

    }