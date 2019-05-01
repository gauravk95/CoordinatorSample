package com.gauravk.coordinatorlayoutsample.ui.adapters

import android.support.v7.util.DiffUtil
import com.gauravk.coordinatorlayoutsample.data.model.Item

class ItemDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(item1: Item, item2: Item): Boolean {
        return item1 == item2
    }

    override fun areContentsTheSame(item1: Item, item2: Item): Boolean {
        return item1.id == item2.id
    }
}