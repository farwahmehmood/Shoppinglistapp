package com.example.shoppinglistapp

import android.app.Application
import com.example.shoppinglistapp.data.db.ShoppingDatabase
import com.example.shoppinglistapp.data.repositories.ShoppingRepository
import com.example.shoppinglistapp.uInterface.Shoppinglist.Shoppingviewmodelfactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ShoppingApplication: Application(),KodeinAware {
    override val kodein: Kodein= Kodein.lazy {
        import(androidXModule(this@ShoppingApplication))
        bind()from singleton { ShoppingDatabase(instance()) }
        bind() from singleton {
            ShoppingRepository(
                instance()
            )
        }

        bind() from provider {
            Shoppingviewmodelfactory(
                instance()
            )
        }
    }


}