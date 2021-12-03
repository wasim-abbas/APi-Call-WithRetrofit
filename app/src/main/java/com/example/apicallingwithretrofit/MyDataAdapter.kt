package com.example.apicallingwithretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apicallingwithretrofit.MyDataAdapter.*

class MyDataAdapter(mainActivity: MainActivity) :
    RecyclerView.Adapter<DataViewHolder>() {

     val dataItem: ArrayList<ModelClass> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_item, parent, false)
        return DataViewHolder(v)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentItem = dataItem[position]

        holder.nationId.text = currentItem.id
        holder.nation.text = currentItem.title
        holder.yearId.text = currentItem.price
        holder.year.text = currentItem.description
        holder.population.text = currentItem.category
    }

    fun updateAllProductList(allProductModel: ArrayList<ModelClass>)
    {
        dataItem.clear()
        dataItem.addAll(allProductModel)
        notifyDataSetChanged()
    }

    override fun getItemCount() = dataItem.size

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nationId = itemView.findViewById<TextView>(R.id.nationID)
        var nation = itemView.findViewById<TextView>(R.id.nation)
        var yearId = itemView.findViewById<TextView>(R.id.yearId)
        var year = itemView.findViewById<TextView>(R.id.year)
        var population = itemView.findViewById<TextView>(R.id.population)
      //  val slungNation = itemView.findViewById<TextView>(R.id.slunNation)


    }
}