package co.ansari.dindinnassignment.ui.components.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import co.ansari.dindinnassignment.R
import kotlinx.android.synthetic.main.image_view.view.*

class SlidingImageAdapter() :
    ListAdapter<Int, SlidingImageAdapter.SlidingImageViewHolder>(SlidingImageDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlidingImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SlidingImageViewHolder(inflater.inflate(R.layout.image_view, parent, false))
    }

    override fun onBindViewHolder(holder: SlidingImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class SlidingImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(image: Int) {
            Log.e("ADAPTER", "Setting image resource $image")
            itemView.image.setImageResource(image)
        }
    }

    class SlidingImageDiffUtil: DiffUtil.ItemCallback<Int>() {

        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }

    }

}