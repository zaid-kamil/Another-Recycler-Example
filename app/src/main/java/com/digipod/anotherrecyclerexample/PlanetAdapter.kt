package com.digipod.anotherrecyclerexample

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlanetAdapter(
    private val context: Context,
    private val planets: Array<String>
): RecyclerView.Adapter<PlanetAdapter.ViewHolder>() {
    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(planet:String){
            view.findViewById<TextView>(android.R.id.text1).text = planet
            view.layoutParams.height = 500
            view.setBackgroundColor((0..0xFFFFFF).random() or 0xFF000000.toInt())
            view.startAnimation(AnimationUtils.loadAnimation(view.context, android.R.anim.slide_in_left))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(planets[position])
    }

    override fun getItemCount() = planets.size

}