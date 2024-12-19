package com.example.thirdapponxml.activities

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.thirdapponxml.R

class BookDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        val title = intent.getStringExtra("title")
        val author = intent.getStringExtra("author")
        val coverUrl = intent.getStringExtra("coverUrl")

        findViewById<TextView>(R.id.detailTitle).text = title
        findViewById<TextView>(R.id.detailAuthor).text = author

        Glide.with(this)
            .load(coverUrl)
            .placeholder(R.drawable.ic_android_black_24dp)
            .into(findViewById(R.id.detailCover))
    }
}