package com.example.mindtoheart.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mindtoheart.R
import com.example.mindtoheart.data.Feedback

class FeedbackAdapter(
    private val context:Context,
    private val dataset:List<Feedback>
): RecyclerView.Adapter<FeedbackAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        val textView:TextView= view.findViewById(R.id.item_title)
        val imageView: ImageView= view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout=LayoutInflater.from(parent.context).inflate(R.layout.feedback_list_item,parent,false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item= dataset[position]
        holder.textView.text= context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    override fun getItemCount()=dataset.size

}