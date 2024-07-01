package com.example.whattodo
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.whattodo.databinding.ActivityAddNoteBinding


class AddNote : AppCompatActivity() {
    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: NoteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteHelper(this)
        binding.saveBtn.setOnClickListener {
           save()
            }
        }

    private fun save() {
        val title = binding.tittleTxt.text.toString().trim()
        val content = binding.contentTxt.text.toString().trim()
        if (title.isEmpty() || content.isEmpty()) {
            Toast.makeText(this, "Please enter both title and content", Toast.LENGTH_SHORT).show()
            return
        }else{
            val note = Note(0, title, content)
            db.insertNote(note)
            Toast.makeText(this, "Note saved successfully", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
