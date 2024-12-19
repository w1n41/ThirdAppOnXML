package com.example.thirdapponxml.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thirdapponxml.R

class AddBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            val title = findViewById<EditText>(R.id.titleInput).text.toString()
            val author = findViewById<EditText>(R.id.authorInput).text.toString()
            val coverUrl = findViewById<EditText>(R.id.coverUrlInput).text.toString()

            if (title.isNotEmpty() && author.isNotEmpty() && coverUrl.isNotEmpty()) {
                setResult(RESULT_OK, Intent().apply {
                    putExtra("title", title)
                    putExtra("author", author)
                    putExtra("coverUrl", coverUrl)
                })
                finish()
            }
        }
    }
}