package com.example.thirdapponxml.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thirdapponxml.BookAdapter
import com.example.thirdapponxml.R
import com.example.thirdapponxml.data.Book

class MainActivity : AppCompatActivity() {
    private lateinit var bookAdapter: BookAdapter
    private val books = mutableListOf<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        setupAddButton()
    }

    private fun setupRecyclerView() {
        bookAdapter = BookAdapter(books) { book ->
            // Handle book click - open detail activity
            val intent = Intent(this, BookDetail::class.java).apply {
                putExtra("title", book.title)
                putExtra("author", book.author)
                putExtra("coverUrl", book.coverUrl)
            }
            startActivity(intent)
        }

        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = bookAdapter
        }
    }

    private fun setupAddButton() {
        findViewById<Button>(R.id.buttonAdd).setOnClickListener {
            startActivityForResult(
                Intent(this, AddBook::class.java),
                ADD_BOOK_REQUEST
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_BOOK_REQUEST && resultCode == RESULT_OK) {
            data?.let {
                val book = Book(
                    it.getStringExtra("title") ?: "",
                    it.getStringExtra("author") ?: "",
                    it.getStringExtra("coverUrl") ?: ""
                )
                bookAdapter.addBook(book)
            }
        }
    }

    companion object {
        const val ADD_BOOK_REQUEST = 1
    }
}