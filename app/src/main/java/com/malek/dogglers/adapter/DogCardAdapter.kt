package com.malek.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.malek.dogglers.R
import com.malek.dogglers.const.Layout
import com.malek.dogglers.data.DataSource
import com.malek.dogglers.model.Dog


/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int,
) : RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // TODO: Initialize the data using the List found in data/DataSource
    private val dogs: List<Dog> = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        // TODO: Declare and initialize all of the list item UI components
        val textViewName: TextView = view!!.findViewById(R.id.name_dog)
        val textViewAge: TextView = view!!.findViewById(R.id.age_dog)
        val textViewHobbies: TextView = view!!.findViewById(R.id.hobbies_dog)
        val imageView: ImageView = view!!.findViewById(R.id.images)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // TODO: Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.
            val adapterLayout = when(layout){
                Layout.GRID ->LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item,parent,false)
                else ->LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item,parent,false)
                }


        // TODO Inflate the layout

        // TODO: Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = dogs.size // TODO: return the size of the data set instead of 0

    override fun onBindViewHolder(holder: DogCardAdapter.DogCardViewHolder, position: Int) {
        // TODO: Get the data at the current position
        val item = dogs[position]
        // TODO: Set the image resource for the current dog
            holder.imageView.setImageResource(item.imageResourceId)
        // TODO: Set the text for the current dog's name
        holder.textViewName.text = item.name
        // TODO: Set the text for the current dog's age
        holder.textViewAge.text = item.age

        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
        val resources = context?.resources
        holder.textViewHobbies.text = resources?.getString(R.string.dog_hobbies, item.hobbies)
    }
}
