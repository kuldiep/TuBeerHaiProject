package com.android_poc.tubeerhaiapplication.fragment

import BeerRootRespTO
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android_poc.tubeerhaiapplication.R
import com.android_poc.tubeerhaiapplication.databinding.FragmentBeerDetailBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BeerDetailBottomSheet.newInstance] factory method to
 * create an instance of this fragment.
 */
class BeerDetailBottomSheet : BottomSheetDialogFragment() {
    // TODO: Rename and change types of parameters
    private var binding:FragmentBeerDetailBottomSheetBinding?=null
    private var beerRootRespTO: BeerRootRespTO? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            beerRootRespTO = it.getSerializable(ARG_PARAM1) as BeerRootRespTO?
            param2 = it.getString(ARG_PARAM2)

        }
       Log.d("LOG","BeerRootRespTO is ="+beerRootRespTO)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_beer_detail_bottom_sheet, container, false)
        binding = DataBindingUtil.bind(view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding?.tvBeerDetails?.text = beerRootRespTO?.description

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BeerDetailBottomSheet.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(beerRootRespTO: BeerRootRespTO, param2: String) =
            BeerDetailBottomSheet().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, beerRootRespTO)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}