package com.example.vk_task1

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.detail_activity)

        val itemNumber = intent.getIntExtra("item_number", -1)

        if (itemNumber != -1) {
            val numberText = findViewById<TextView>(R.id.detail_number)
            numberText.text = itemNumber.toString()
            numberText.setBackgroundResource(if (itemNumber % 2 == 0) R.color.red else R.color.blue)
        }
    }
}