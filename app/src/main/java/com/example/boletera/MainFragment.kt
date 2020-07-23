package com.example.boletera

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.boletera.EventAdapter



class MainFragment : Fragment() {

    var recyclerView: RecyclerView? = null
    var adapter: EventAdapter? = null
    var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val events = ArrayList<Event>()
        events.add(Event(requireContext().getString(R.string.title_1), requireContext().getString(R.string.description_1), R.drawable.iv_picture_1))
        events.add(Event(requireContext().getString(R.string.title_2), requireContext().getString(R.string.description_2), R.drawable.iv_picture_2))
        events.add(Event(requireContext().getString(R.string.title_3), requireContext().getString(R.string.description_3), R.drawable.iv_picture_3))
        events.add(Event(requireContext().getString(R.string.title_4), requireContext().getString(R.string.description_4), R.drawable.iv_picture_4))
        events.add(Event(requireContext().getString(R.string.title_1), requireContext().getString(R.string.description_1), R.drawable.iv_picture_1))
        events.add(Event(requireContext().getString(R.string.title_2), requireContext().getString(R.string.description_2), R.drawable.iv_picture_2))
        events.add(Event(requireContext().getString(R.string.title_3), requireContext().getString(R.string.description_3), R.drawable.iv_picture_3))
        events.add(Event(requireContext().getString(R.string.title_4), requireContext().getString(R.string.description_4), R.drawable.iv_picture_4))

        recyclerView = view.findViewById(R.id.rv_event)

        layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.layoutManager = layoutManager
        adapter = EventAdapter(events) {
            Toast.makeText(requireContext(),it.title, Toast.LENGTH_LONG).show()
        }
        recyclerView?.adapter = adapter
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment

    }
}