package com.example.shoppinglistapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppinglistapp.data.db.entities.ShoppingItem


@Database(
    entities = [ShoppingItem::class],
    version=1
)

abstract class ShoppingDatabase: RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        @Volatile
        private var instance: ShoppingDatabase? = null
        private val L0CK = Any()
        operator fun invoke(context: Context) = instance
            ?: synchronized(L0CK) {
                instance
                    ?: createDatabase(
                        context
                    ).also { instance = it }
            }


        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDatabase::class.java,
                "ShoppingDB.db"
            ).build()
    }
}
