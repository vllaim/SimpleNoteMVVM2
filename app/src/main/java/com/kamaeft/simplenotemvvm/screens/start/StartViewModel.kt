package com.kamaeft.simplenotemvvm.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.kamaeft.simplenotemvvm.Const.REPOSITORY
import com.kamaeft.simplenotemvvm.db.NoteDataBase
import com.kamaeft.simplenotemvvm.db.repository.NoteRealization
import com.kamaeft.simplenotemvvm.model.NoteModel

class StartViewModel(application : Application) : AndroidViewModel(application) {

    val context = application

    fun initDataBase(){
        val daoNote = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNotes() : LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }
}