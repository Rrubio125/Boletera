package com.example.boletera

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class SearchFragment : Fragment() {

    private var searchRecyclerView:RecyclerView? = null
    var adapter:SearchAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categories = ArrayList<EventCategory>()
        categories.add(EventCategory(EventCategoryType.CONCERT))
        categories.add(EventCategory(EventCategoryType.CONFERENCE))
        categories.add(EventCategory(EventCategoryType.CULTURAL))
        categories.add(EventCategory(EventCategoryType.SPORTS))
        categories.add(EventCategory(EventCategoryType.FESTIVAL))
        categories.add(EventCategory(EventCategoryType.WORKSHOP))

        searchRecyclerView = view.findViewById(R.id.rv_categories)
        val gridLayoutManager = StaggeredGridLayoutManager(
            2,
            StaggeredGridLayoutManager.VERTICAL
        )
        adapter = SearchAdapter(categories) {
            Toast.makeText(requireContext(), it , Toast.LENGTH_LONG).show()
        }
        this.searchRecyclerView?.layoutManager = gridLayoutManager
        this.searchRecyclerView?.adapter = adapter
    }
}