package com.example.shoppinglistapp.uInterface.Shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglistapp.data.repositories.ShoppingRepository

@Suppress("UNCHECKED_CAST")
class Shoppingviewmodelfactory(
    private val repository: ShoppingRepository
): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return Shoppingviewmodel(repository) as T
    }
}