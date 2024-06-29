package com.example.whattodo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.whattodo.databinding.ActivityAddNoteBinding
import com.example.whattodo.databinding.ActivityMainBinding

class AddNote : AppCompatActivity() {
    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: NoteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteHelper(this)
        binding.saveBtn.setOnClickListener {
            val title = binding.tittleTxt.text.toString()
            val content = binding.contentTxt.text.toString()
            val note = Note(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this,"saved",Toast.LENGTH_SHORT).show()
            }
        }
    }
