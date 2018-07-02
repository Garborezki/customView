package com.example.nikita.customview.other.graphView.recyclerView

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.nikita.customview.R
import kotlinx.android.synthetic.main.graph_element.view.*

class GraphRecyclerAdapter() : RecyclerView.Adapter<GraphRecyclerAdapter.GraphElement>() {

    lateinit var graphElementArray: IntArray

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GraphElement {
        return GraphElement(LayoutInflater.from(parent.context).inflate(R.layout.graph_element, parent, false))
    }

    override fun getItemCount(): Int {
        return graphElementArray.size
    }

    override fun onBindViewHolder(holder: GraphElement, position: Int) {
        holder.graphElement.layoutParams.height = graphElementArray[position]
    }

    fun updateGraphElements(arr: IntArray) {
        graphElementArray = arr
        notifyDataSetChanged()
    }

    class GraphElement(view: View) : RecyclerView.ViewHolder(view) {
        val graphElement = view.graphColimn!!

        init {
            view.graphColimn.setBackgroundColor(Color.BLUE)
            graphElement.setOnTouchListener { view, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        view.graphColimn.setBackgroundColor(Color.RED)
                    }

                    MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL-> {
                        view.graphColimn.setBackgroundColor(Color.BLUE)
                    }

                }
                true
            }
        }
    }

}