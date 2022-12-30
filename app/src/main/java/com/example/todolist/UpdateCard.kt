package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_create_card.create_priority
import kotlinx.android.synthetic.main.activity_create_card.create_title
import kotlinx.android.synthetic.main.activity_update_card.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateCard : AppCompatActivity() {
    private lateinit var database: myDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_card)
        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "To_Do"
        ).build()

        val pos = intent.getIntExtra ("id", -1)
        if(pos!=-1){
            val title =DataObject.getData(pos).title
            val priority=DataObject.getData(pos).priority

            create_title.setText(title)
            create_priority.setText(priority)

            delete_button.setOnClickListener {
                DataObject.deleteData(pos)
                GlobalScope.launch {
                    database.dao().deleteTask(
                        Entityy(
                            pos + 1,
                            create_title.text.toString(),
                            create_priority.text.toString()
                        )
                    )
                }
                myIntent()
            }
            update_button.setOnClickListener {
                DataObject.updateData(pos,
                    create_title.text.toString(),
                    create_priority.text.toString())
                Toast.makeText(this, title + " " + priority, Toast.LENGTH_SHORT).show()
                GlobalScope.launch {
                    database.dao().updateTask(
                        Entityy(pos + 1, create_title.text.toString(), create_priority.text.toString())
                    )
                }
                myIntent()
            }

        }


    }
    fun myIntent(){
        val intent =Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}