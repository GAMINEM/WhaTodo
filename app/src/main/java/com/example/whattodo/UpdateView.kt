package com.example.whattodo
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.whattodo.databinding.ActivityUpdateViewBinding

class UpdateView : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateViewBinding
    private lateinit var db: NoteHelper
    private var noteId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


    db = NoteHelper(this)

        noteId = intent.getIntExtra("noteId", -1)
        if (noteId == -1) {
            finish()
            return
        }
            val note = db.getNoteById(noteId)
            if (note != null) {
                binding.UpdateTittleTxt.setText(note.title)
                binding.UpdateContentTxt.setText(note.content)

                findViewById<ImageView>(R.id.UpdateBtn).setOnClickListener {
                        val newTitle = binding.UpdateTittleTxt.text.toString()
                        val newContent = binding.UpdateContentTxt.text.toString()
                    if (newTitle.isEmpty() || newContent.isEmpty()) {
                        Toast.makeText(this,"Please enter both title and content", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener}

                        val updatedNote = Note(noteId, newTitle, newContent)
                            db.upDateNote(updatedNote)
                            Toast.makeText(this, "Note updated successfully", Toast.LENGTH_SHORT).show()
                            finish()

                    }
                binding.deleteBtn.setOnClickListener {
                    db.deleteNote(noteId)
                    Toast.makeText(this, "Note deleted successfully", Toast.LENGTH_SHORT).show()
                        finish()
                }
        }

    }
}