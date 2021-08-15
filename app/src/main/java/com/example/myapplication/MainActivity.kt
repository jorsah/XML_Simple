    package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var layoutManager: LinearLayoutManager
    private lateinit var myAdapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myAdapter = Adapter(mutableListOf<Item>())

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = myAdapter
        myAdapter.setItemList(ItemList)

        val finalPrice: TextView = all

        var fp = 0
        for (i in 0 until ItemList.size) {
            fp += ItemList[i].price
        }

        finalPrice.text = "Всего: $fp₽"
    }
}