package com.example.todolist

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities =[Entityy::class], version=1)
abstract  class myDatabase: RoomDatabase() {
    abstract fun dao():DAO

}