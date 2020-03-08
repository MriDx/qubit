package com.qubit.kpt.mobile

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


import com.qubit.kpt.mobile.ui.fragments.AccidenceFragment.OnListFragmentInteractionListener
import com.qubit.kpt.mobile.model.AccidenceModel.AccidenceItem

import kotlinx.android.synthetic.main.fragment_event.view.*

/**
 * [RecyclerView.Adapter] that can display a [AccidenceItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class MyEventRecyclerViewAdapter(
    private val mValues: List<AccidenceItem>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MyEventRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as AccidenceItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_event, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.accidencePlace.text = item.address
        holder.accidentDescription.text = item.comment
        holder.accidentTime.text = item.createdAt
        holder.accidentDistance.text = item.distance

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val accidencePlace: TextView = mView.accidentPlace
        val accidentDescription: TextView = mView.accidentDescription
        val accidentTime: TextView = mView.accidentTime
        val accidentDistance: TextView = mView.accidentDistance


        override fun toString(): String {
            return super.toString() + "PLACE=$accidencePlace DESCRIPTION=$accidentDescription" +
                    "TIME=$accidentTime DISTANCE=$accidentDistance"
        }
    }
}
