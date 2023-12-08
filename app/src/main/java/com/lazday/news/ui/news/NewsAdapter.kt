package com.lazday.news.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lazday.news.databinding.AdapterNewsBinding
import com.lazday.news.source.model.ArticleModel

class NewsAdapter(
    val articles: ArrayList<ArticleModel>,
    val listener: OnAdapterListener
): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterNewsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(article: ArticleModel){
            binding.article = article
        }
    }

    interface OnAdapterListener {
        fun onClick(article: ArticleModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterNewsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
        holder.itemView.setOnClickListener {
            listener.onClick(article)
        }
    }

    fun add(data: List<ArticleModel>) {
        articles.clear()
        articles.addAll(data)
        notifyDataSetChanged()
    }
}