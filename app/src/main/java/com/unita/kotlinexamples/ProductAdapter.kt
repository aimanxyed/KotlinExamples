package com.unita.kotlinexamples

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(var c: Context, var list:ArrayList<Product>):RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
      var myview = LayoutInflater.from(c).inflate(R.layout.my_row,parent,false)
        return MyProduct(myview)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyProduct).bind(list[position].name,list[position].price, list[position].photo )
    }

    override fun getItemCount(): Int {
       return list.size
    }

    class MyProduct(view: View) :RecyclerView.ViewHolder(view)
    {
        var tv_name= view.findViewById<TextView>(R.id.pro_name)
        var tv_price= view.findViewById<TextView>(R.id.pro_price)
        var iv_photo= view.findViewById<ImageView>(R.id.pro_photo)
        fun bind(n:String, p:Int, ph:Int)
        {
            tv_name.text=n
            tv_price.text=p.toString()
            iv_photo.setImageResource(ph)

        }
    }

}