package com.example.jonsays

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import com.example.jonsays.databinding.PageLayoutBinding

class PageAdapter(private val listener: PageItemListener) :
RecyclerView.Adapter<PageAdapter.PageViewHolder>(){

    private val pages = ArrayList<Page>()

    override fun getItemCount() = pages.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
      val binding = PageLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PageViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) = holder.bind(pages[position])

    inner class PageViewHolder(private val pageBinding: PageLayoutBinding,
                                 private val listener: PageItemListener)
        : RecyclerView.ViewHolder(pageBinding.root),
        View.OnClickListener, View.OnLongClickListener {

        init {
            pageBinding.root.setOnClickListener(this)
            pageBinding.root.setOnLongClickListener(this)
        }

        fun bind(page: Page) {
            pageBinding.title.text = page.title

            if (page.favorite) {
                pageBinding.favorite.setImageResource(R.drawable.ic_baseline_favorite)
            } else {
                pageBinding.favorite.setImageResource(R.drawable.ic_baseline_favorite_border)
            }
        }

        override fun onClick(v: View?) {
            listener.onPageClick(pages[adapterPosition].id)
        }

        override fun onLongClick(p0: View?): Boolean {
            listener.onPageLongClick(pages[adapterPosition])
            return true
        }
    }

    interface PageItemListener {
        fun onPageClick(recipeId : Int)
        fun onPageLongClick(page: Page)
    }
}
