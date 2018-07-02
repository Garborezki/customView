package com.example.nikita.customview.other.graphView

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.widget.LinearLayout
import com.example.nikita.customview.other.graphView.recyclerView.GraphRecyclerAdapter

class GraphView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private val graphRecyclerView = RecyclerView(context)
    var adapter = GraphRecyclerAdapter()

    init {
        addView(graphRecyclerView)
        graphRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        graphRecyclerView.adapter = adapter
    }

    fun setGraphElement(arr: IntArray) {
        adapter.updateGraphElements(arr)
    }


}