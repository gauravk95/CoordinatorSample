package com.gauravk.coordinatorlayoutsample.ui.main

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.gauravk.coordinatorlayoutsample.R
import com.gauravk.coordinatorlayoutsample.ui.adapters.MainItemListAdapter
import com.gauravk.coordinatorlayoutsample.ui.custom.MultiCollapseListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set up the adapter for recycler view
        val adapter = MainItemListAdapter()
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

        setupListeners()
        subscribeUi(adapter)
    }

    private fun subscribeUi(adapter: MainItemListAdapter) {
        viewModel = MainViewModel()

        viewModel.itemList.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    private fun setupListeners() {
        app_bar_layout.addOnOffsetChangedListener(MultiCollapseListener(app_bar_layout))
    }

}
