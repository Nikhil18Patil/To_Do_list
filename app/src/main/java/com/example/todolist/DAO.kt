package com.example.todolist

import androidx.room.*

@Dao
interface DAO {
    @Insert
    suspend fun insertTask(entity: Entityy)

    @Update
    suspend fun updateTask(entity: Entityy)

    @Delete
    suspend fun deleteTask(entity: Entityy)

    @Query("Delete from To_do")
    suspend fun deleteAll()

    @Query("Select * from To_do")
    suspend fun getTask(): List<CardInfo>
}