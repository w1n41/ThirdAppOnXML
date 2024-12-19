package com.example.thirdapponxml

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thirdapponxml.data.Book

class BookAdapter(
    private val books: MutableList<Book>,
    private val onItemClick: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val coverImage: ImageView = view.findViewById(R.id.bookCover)
        val titleText: TextView = view.findViewById(R.id.bookTitle)
        val authorText: TextView = view.findViewById(R.id.bookAuthor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_items_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.titleText.text = book.title
        holder.authorText.text = book.author

        Glide.with(holder.itemView.context)
            .load(book.coverUrl)
            .placeholder(R.drawable.ic_android_black_24dp)
            .into(holder.coverImage)

        holder.itemView.setOnClickListener { onItemClick(book) }
    }

    override fun getItemCount() = books.size

    fun addBook(book: Book) {
        books.add(book)
        notifyItemInserted(books.size - 1)
    }
}