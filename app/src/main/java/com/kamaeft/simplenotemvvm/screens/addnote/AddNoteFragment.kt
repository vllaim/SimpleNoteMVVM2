package com.kamaeft.simplenotemvvm.screens.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.kamaeft.simplenotemvvm.Const.APP
import com.kamaeft.simplenotemvvm.R
import com.kamaeft.simplenotemvvm.databinding.FragmentAddNoteBinding
import com.kamaeft.simplenotemvvm.model.NoteModel


class AddNoteFragment : Fragment() {
    lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)
        binding.btnAddNote.setOnClickListener {
            val title = binding.etAddTitle.text.toString()
            val description = binding.etAddDescription.text.toString()

            viewModel.insert(NoteModel(title = title, description = description)){}
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }

        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
    }

}