package com.example.vk_task1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var addButton: View
    private val data = mutableListOf<Int>()
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.activity_main__rv)
        addButton = findViewById(R.id.activity_main__button)

        val numColumns = resources.getInteger(R.integer.grid_columns)

        val layoutManager = GridLayoutManager(this, numColumns)
        recyclerView.layoutManager = layoutManager

        if (savedInstanceState != null) {
            data.addAll(savedInstanceState.getIntegerArrayList("data") ?: emptyList())
        }

        adapter = MainAdapter(data)
        recyclerView.adapter = adapter

        addButton.setOnClickListener {
            val newItem = data.size
            data.add(newItem)
            adapter.notifyItemInserted(newItem)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntegerArrayList("data", ArrayList(data))
    }
}
