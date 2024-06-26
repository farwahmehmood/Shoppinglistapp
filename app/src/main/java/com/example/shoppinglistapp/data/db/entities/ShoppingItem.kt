package com.example.shoppinglistapp.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "shopping_items")
data class ShoppingItem(

    @ColumnInfo(name="shopping_item")
    var name: String,
    @ColumnInfo(name="item_amount")
    var amount:Int
)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int?=null
}