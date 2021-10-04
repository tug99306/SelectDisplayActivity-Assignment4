package edu.temple.selectactivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter (var _context: Context, var _imageObjects: Array<ImageObject>, val clickListener: (ImageObject) -> Unit) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>()
{

    val inflater = LayoutInflater.from(_context)

    class ImageViewHolder(val _itemView : View) : RecyclerView.ViewHolder(_itemView){


        fun bind(images: ImageObject, clickListener: (ImageObject) -> Unit) {
            var title: TextView =  _itemView.findViewById(R.id.title)
            var image: ImageView = _itemView.findViewById(R.id.image)

            title.text = images.description
            image.setImageResource(images.imageId)
            itemView.setOnClickListener { clickListener(images)}

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        var view = inflater.inflate(R.layout.recycler_layout,parent, false)
        return ImageViewHolder(view)
    }


    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(_imageObjects[position], clickListener)

    }

    override fun getItemCount(): Int {
        return _imageObjects.size
    }





}
