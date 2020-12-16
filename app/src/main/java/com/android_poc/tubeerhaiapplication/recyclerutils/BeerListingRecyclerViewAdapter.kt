package com.android_poc.tubeerhaiapplication.recyclerutils

import BeerRootRespTO
import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.android_poc.tubeerhaiapplication.R
import com.android_poc.tubeerhaiapplication.fragment.BeerDetailBottomSheet
import com.squareup.picasso.Picasso

class BeerListingRecyclerViewAdapter (var beerRootRespTOList: List<BeerRootRespTO>, val context: Context) :
RecyclerView.Adapter<BeerListingRecyclerViewAdapter.BeerListingViewHolder>() {

    class BeerListingViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view) {
        var tvBeerName: TextView = view.findViewById(R.id.tvBeerName)
        var ivBeerImg: ImageView = view.findViewById(R.id.ivBeerImg)
        val cvRootItem = view.findViewById<CardView>(R.id.cvRootItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerListingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.beer_item, parent, false
        )
        return BeerListingViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: BeerListingViewHolder, position: Int) {
        if(beerRootRespTOList.get(position).image_url!=null){
            Picasso.get().load(beerRootRespTOList.get(position).image_url).into(holder.ivBeerImg)
        }
        if(beerRootRespTOList.get(position).name!=null){
            holder.tvBeerName.text = beerRootRespTOList.get(position).name
        }
        holder.cvRootItem.setOnLongClickListener(object:View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                Log.d("LOG","OnLongClick called")
                val beerDetailBottomSheet = BeerDetailBottomSheet.newInstance(
                    beerRootRespTOList[position]," ")
                beerDetailBottomSheet.show((context as AppCompatActivity).supportFragmentManager,beerDetailBottomSheet.tag)
                return true
            }

        })
    }

    override fun getItemCount(): Int {
        return beerRootRespTOList.size
    }
    fun setBeerRootRespTOListFromUi(beerRootRespTOList: List<BeerRootRespTO>) {
        this.beerRootRespTOList = beerRootRespTOList
        notifyDataSetChanged()
    }

}