package com.example.myapp_project_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgFood: ImageView = findViewById(R.id.img_food)
        val tvFoodName: TextView = findViewById(R.id.tv_food_name)
        val tvFoodDescription: TextView = findViewById(R.id.tv_food_description)

        // Ambil data dari Intent
        val name = intent.getStringExtra("EXTRA_NAME")
        val description = intent.getStringExtra("EXTRA_DESCRIPTION")
        val photo = intent.getIntExtra("EXTRA_PHOTO", 0)

        // Set data ke layout
        imgFood.setImageResource(photo)
        tvFoodName.text = name
        tvFoodDescription.text = description
    }
}
