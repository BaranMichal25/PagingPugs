package io.spacecowboyapps.pugs.ui.main

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import io.spacecowboyapps.pugs.R
import io.spacecowboyapps.pugs.data.db.Pug
import kotlinx.android.synthetic.main.item.view.*
import javax.inject.Inject

class MainAdapter
@Inject constructor(
    private val picasso: Picasso
) : PagedListAdapter<Pug, MainAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pug = getItem(position)
        if (pug != null)
            holder.bindTo(pug)
        else
            holder.clear()
    }

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val backgroundView = item.imageView_background
        private val nameView = item.textView_name

        fun bindTo(pug: Pug) {
            picasso.load(pug.image).into(backgroundView)
            nameView.text = pug.name
        }

        fun clear() {
            picasso.load(R.drawable.placeholder).into(backgroundView)
            nameView.text = ""
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Pug>() {

            override fun areItemsTheSame(old: Pug, new: Pug): Boolean {
                return old.id == new.id
            }

            override fun areContentsTheSame(old: Pug, new: Pug): Boolean {
                return old == new
            }
        }
    }
}