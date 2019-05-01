package com.gauravk.coordinatorlayoutsample.ui.main

import android.arch.lifecycle.MutableLiveData
import com.gauravk.coordinatorlayoutsample.data.model.Item
import com.gauravk.coordinatorlayoutsample.data.source.SampleDataGenerator

/**
 * ViewModel for the [MainActivity] screen.
 */
class MainViewModel {

    val itemList: MutableLiveData<List<Item>> = MutableLiveData()

    init {
        itemList.value = SampleDataGenerator.getSampleData()
    }
}