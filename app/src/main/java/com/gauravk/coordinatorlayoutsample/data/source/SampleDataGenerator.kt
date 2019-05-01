package com.gauravk.coordinatorlayoutsample.data.source

import com.gauravk.coordinatorlayoutsample.data.model.Item
import android.graphics.Color
import java.util.*

object SampleDataGenerator {

    fun getSampleData(): MutableList<Item> {
        //create a list
        val itemList = mutableListOf<Item>()
        for (i in 1..100) {
            val rnd = Random()
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            itemList.add(Item("id_$i", "Name $i", color))
        }
        return itemList
    }
}