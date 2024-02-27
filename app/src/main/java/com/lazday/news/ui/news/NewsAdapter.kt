package com.lazday.news.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lazday.news.databinding.AdapterHeadlineBinding
import com.lazday.news.databinding.AdapterNewsBinding
import com.lazday.news.source.model.ArticleModel

private const val HEADLIENS = 1
private const val NEWS = 2

class NewsAdapter(
    val articles: ArrayList<ArticleModel>,
    val listener: OnAdapterListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        var VIEW_TYPES = HEADLIENS
    }

    class ViewHolderNews(val binding: AdapterNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: ArticleModel) {
            binding.article = article
        }
    }

    class ViewHolderHeadlines(val binding: AdapterHeadlineBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: ArticleModel) {
            binding.article = article
        }
    }


    interface OnAdapterListener {
        fun onClick(article: ArticleModel)
    }

    override fun getItemViewType(position: Int) = VIEW_TYPES

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HEADLIENS) {
            ViewHolderHeadlines(
                AdapterHeadlineBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        } else {
            ViewHolderNews(
                AdapterNewsBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val article = articles[position]
        if (VIEW_TYPES == HEADLIENS) (holder as ViewHolderHeadlines).bind(article)
        else (holder as ViewHolderNews).bind(article)
        holder.itemView.setOnClickListener {
            listener.onClick(article)
        }
    }

    fun add(data: List<ArticleModel>) {
        articles.addAll(data)
        notifyItemRangeInserted((articles.size - data.size), data.size)
    }

    fun clear() {
        articles.clear()
        notifyDataSetChanged()
    }
}