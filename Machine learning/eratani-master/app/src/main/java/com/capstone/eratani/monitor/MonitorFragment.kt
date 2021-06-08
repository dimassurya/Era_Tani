package com.capstone.eratani.monitor

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.eratani.R
import com.capstone.eratani.databinding.FragmentMonitorBinding
import com.capstone.eratani.utils.DataDummy
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class MonitorFragment : Fragment() {
    private lateinit var fragmentMonitorBinding: FragmentMonitorBinding
    private val TAG = MonitorFragment::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentMonitorBinding = FragmentMonitorBinding.inflate(layoutInflater, container, false)
        return fragmentMonitorBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val rootRef = FirebaseDatabase.getInstance().reference
            rootRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (s in snapshot.children) {
                        val humidity = s.child("humidity").getValue().toString()
                        val temperature = s.child("temperature").getValue().toString()
                        fragmentMonitorBinding.tvItemHumid.text = humidity
                        fragmentMonitorBinding.tvItemTemp.text = temperature
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.w(TAG, "Failed to read value.", error.toException())
                }
            })
        }
    }
}