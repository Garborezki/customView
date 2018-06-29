package com.example.nikita.customview.presentetion.mainScreen

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nikita.customview.R
import com.example.nikita.customview.presentetion.recyclerView.GraphRecyclerAdapter
import kotlinx.android.synthetic.main.main_screen.*

class MainScreenFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arr = IntArray(5)
        arr[0] = 200
        arr[1] = 250
        arr[2] = 400
        arr[3] = 500
        arr[4] = 150

        graphRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = GraphRecyclerAdapter(arr)
        graphRecyclerView.adapter = adapter

    }

}
