package com.example.shoppinglistapp.uInterface.Shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoppinglistapp.data.db.entities.ShoppingItem
import com.example.shoppinglistapp.data.repositories.ShoppingRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Shoppingviewmodel (
    private val repository: ShoppingRepository): ViewModel()
{
        @OptIn(DelicateCoroutinesApi::class)
        fun upsert(item: ShoppingItem)=
            GlobalScope.launch {
                repository.upsert(item) }

    @OptIn(DelicateCoroutinesApi::class)
    fun delete(item: ShoppingItem)=GlobalScope.launch {
        repository.delete(item)
    }

    fun getAllShoppingItems()=repository.getAllShoppingItems()

}