package com.android_poc.tubeerhaiapplication.recyclerutils

import BeerRootRespTO
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerListingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.beer_item, parent, false
        )
        return BeerListingViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: BeerListingViewHolder, position: Int) {
        Picasso.get().load(beerRootRespTOList.get(position).image_url).into(holder.ivBeerImg)
        holder.tvBeerName.text = beerRootRespTOList.get(position).name
        holder.cvRootItem.setOnLongClickListener(object:View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                Log.d("LOG","OnLongClick called")
                val beerDetailBottomSheet = BeerDetailBottomSheet.newInstance(
                    beerRootRespTOList[position]," ")
                beerDetailBottomSheet.show((context as AppCompatActivity).supportFragmentManager,beerDetailBottomSheet.tag)
                return true
            }
        })
        holder.ibShare.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(Intent.EXTRA_TEXT, beerRootRespTOList[position].name)
                sendIntent.type = "text/plain"
                sendIntent.setPackage("com.whatsapp");
                context.startActivity(sendIntent)

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

    class BeerListingViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view) {
        var tvBeerName: TextView = view.findViewById(R.id.tvBeerName)
        var ivBeerImg: ImageView = view.findViewById(R.id.ivBeerImg)
        val cvRootItem = view.findViewById<CardView>(R.id.cvRootItem)
        val ibShare = view.findViewById<ImageButton>(R.id.ibShare)

    }
}