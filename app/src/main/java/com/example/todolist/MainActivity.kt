package com.example.todolist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var database: myDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Room.databaseBuilder( applicationContext, myDatabase::class.java, "To_Do").build()

        add.setOnClickListener {
            val intent =Intent(this, CreateCard::class.java)
            startActivity(intent)
        }

        delete_all.setOnClickListener {
            DataObject.deleteAll()
            GlobalScope.launch {
                database.dao().deleteAll()
            }
            setrecycler()
        }


           setrecycler()

    }
    private fun setrecycler(){
        recycle_view.adapter = Adapter(DataObject.getAllData())
        recycle_view.layoutManager=LinearLayoutManager(this)
    }
}