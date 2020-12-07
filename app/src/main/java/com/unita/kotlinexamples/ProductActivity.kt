package com.unita.kotlinexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        var list=ArrayList<Product>()
        list.add(Product("Pizza", 340 , R.drawable.pizza))
        list.add(Product("Burger", 980 , R.drawable.burger))
        var adp=ProductAdapter(this, list)
        rv_pro.layoutManager=LinearLayoutManager(this)
        rv_pro.adapter=adp



    }
}