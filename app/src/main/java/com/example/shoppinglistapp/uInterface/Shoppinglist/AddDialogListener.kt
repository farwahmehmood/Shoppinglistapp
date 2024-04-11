package com.example.shoppinglistapp.uInterface.Shoppinglist

import com.example.shoppinglistapp.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(itemL: ShoppingItem)
}