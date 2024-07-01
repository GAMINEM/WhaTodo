package com.example.whattodo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.whattodo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: NoteHelper
    private lateinit var notesAdapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteHelper(this)
        notesAdapter = NotesAdapter(db.getAllNotes())

        binding.addBtn.setOnClickListener {
            val intent = Intent(this, AddNote::class.java)
            startActivity(intent)
        }
        //RECYCLER VIEW
        binding.notes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.notes.adapter = notesAdapter

    }

    override fun onResume() {
        super.onResume()
        val notes = db.getAllNotes()
        notesAdapter.refreshData(notes)
    }

}
