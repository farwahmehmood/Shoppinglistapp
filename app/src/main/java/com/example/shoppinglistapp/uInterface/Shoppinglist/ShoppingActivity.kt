package com.example.shoppinglistapp.uInterface.Shoppinglist

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.data.db.ShoppingDatabase
import com.example.shoppinglistapp.data.db.entities.ShoppingItem
import com.example.shoppinglistapp.data.repositories.ShoppingRepository
import com.example.shoppinglistapp.other.ShoppingItemAdapter
import com.example.shoppinglistapp.ui.theme.ShoppinglistappTheme
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.kodein.di.Kodein

import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : ComponentActivity(), KodeinAware{
    override val kodein by kodein()
    private val factory: Shoppingviewmodelfactory by instance()



    @SuppressLint("CutPasteId", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
//        val database= ShoppingDatabase(this)
//         val repository= ShoppingRepository(database)
//        val factory=Shoppingviewmodelfactory(repository)
        val viewmodel= ViewModelProvider(this, factory).get(Shoppingviewmodel::class.java)

        val adapter= ShoppingItemAdapter(listOf(),viewmodel)

        findViewById<RecyclerView>(R.id.rvShoppingItems).layoutManager=LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.rvShoppingItems).adapter=adapter
        viewmodel.getAllShoppingItems().observe(this, Observer {
            adapter.items=it
            adapter.notifyDataSetChanged()
        })

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            AddShoppingItemDialog(this,object : AddDialogListener{
                override fun onAddButtonClicked(itemL: ShoppingItem) {
                    viewmodel.upsert(itemL)
                }

            }).show()
        }


    }
}


