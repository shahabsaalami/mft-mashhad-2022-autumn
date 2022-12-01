package com.example.myapplication.fragment

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.LetterAdapter
import com.example.myapplication.data.SettingsDataStore
import com.example.myapplication.databinding.FragmentLetterListBinding
import kotlinx.coroutines.launch


class LetterListFragment : Fragment() {

    private var _binding: FragmentLetterListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true

    private lateinit var SettingsDataStore: SettingsDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        SettingsDataStore = SettingsDataStore(requireContext())

        _binding = FragmentLetterListBinding.inflate(inflater, container, false)
        val view = binding.root
        recyclerView = binding.recyclerView
        SettingsDataStore.preferenceFlow.asLiveData().observe(
            viewLifecycleOwner
        ) {
            isLinearLayoutManager = it
            chooseLayout()
            activity?.invalidateOptionsMenu()

        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)
        val layoutButton = menu.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager

                lifecycleScope.launch{
                    SettingsDataStore.saveLayoutToPreferencesStore(isLinearLayoutManager,requireContext())
                }
//                chooseLayout()
//                setIcon(item)

                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_grid_view)
            else ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_view_stream_24)
    }
    fun chooseLayout() {
        if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        } else {
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
        }
        val listOfChars = ('A').rangeTo('Z')
        recyclerView.adapter = LetterAdapter(listOfChars.toList())
    }

}