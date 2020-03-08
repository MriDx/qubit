package com.qubit.kpt.mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.qubit.kpt.mobile.model.AccidenceModel
import com.qubit.kpt.mobile.ui.fragments.AccidenceFragment

class HomeActivity : AppCompatActivity(), AccidenceFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onListFragmentInteraction(item: AccidenceModel.AccidenceItem?) {
    }
}
