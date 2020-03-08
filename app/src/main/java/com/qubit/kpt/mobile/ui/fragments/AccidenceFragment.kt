package com.qubit.kpt.mobile.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.qubit.kpt.mobile.model.AccidenceModel.AccidenceItem
import com.qubit.kpt.mobile.MyEventRecyclerViewAdapter
import com.qubit.kpt.mobile.R
import com.qubit.kpt.mobile.model.AccidenceModel

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [AccidenceFragment.OnListFragmentInteractionListener] interface.
 */
class AccidenceFragment : Fragment() {

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_event_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                adapter = MyEventRecyclerViewAdapter(
                    AccidenceModel.ITEMS,
                    listener
                )
            }
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     */
    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: AccidenceItem?)
    }
}
