package com.example.todolist

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "To_do")

/** I have changed the name of this Entity class */
data class Entityy(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var priority: String

    )

