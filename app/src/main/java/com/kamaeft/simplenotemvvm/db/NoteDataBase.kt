package com.kamaeft.simplenotemvvm.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kamaeft.simplenotemvvm.db.dao.NoteDao
import com.kamaeft.simplenotemvvm.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {
        private var database : NoteDataBase ?= null

        fun getInstance(context: Context): NoteDataBase{
            return if (database == null){
                database = Room.databaseBuilder(context, NoteDataBase::class.java, "db").build()
                database as NoteDataBase
            }else {
                database as NoteDataBase
            }
        }
    }
}
