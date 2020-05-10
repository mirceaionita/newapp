package com.mionita.newsapp.ui.favorite

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mionita.newsapp.R
import com.mionita.newsapp.model.FavoriteNewsContent


import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.fragment_news_item.view.*

class FavoriteRecyclerViewAdapter(
    private val mValues: List<FavoriteNewsContent.NewsItem>,
    private val mListener: FavoriteNewsFragment.OnListFragmentInteractionListener?
) : RecyclerView.Adapter<FavoriteRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as FavoriteNewsContent.NewsItem
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_news_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mTitleView.text = item.title
//        holder.mContentView.text = item.details
        if (item.image.isNotEmpty()) {
            Picasso.get().load(item.image).into(holder.mImageView);
        }

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mTitleView: TextView = mView.item_title
//        val mContentView: TextView = mView.item_content
        val mImageView: ImageView = mView.item_image

        override fun toString(): String {
            return super.toString() + " '" + mTitleView.text + "'"
        }
    }
}
