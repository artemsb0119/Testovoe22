package com.example.testovoe22

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

class DetailActivity : AppCompatActivity() {

    private lateinit var vlevo: ImageView
    private lateinit var textViewLessons: TextView
    private lateinit var textViewText: TextView
    private lateinit var buttonDone: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textViewText = findViewById(R.id.textViewText)
        textViewLessons = findViewById(R.id.textViewLessons)
        buttonDone = findViewById(R.id.buttonDone)
        buttonDone.setOnClickListener {
            val lesson = intent.getSerializableExtra("lesson") as? LessonsItem
            val editor = getSharedPreferences("my_preferences", Context.MODE_PRIVATE).edit()
            if (lesson != null) {
                editor.putBoolean("${lesson.id}", true)
                editor.apply()
            }
            finish()

        }
        vlevo = findViewById(R.id.vlevo)
        vlevo.setOnClickListener {
            finish()
        }
        loadData()
    }

    private fun loadData() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val lesson = intent.getSerializableExtra("lesson") as? LessonsItem
                if (lesson != null) {
                    val data = URL("http://135.181.248.237/22/detail${lesson.id}.json").readText()
                    val gson = Gson()
                    val detail = gson.fromJson(data, DetailItem::class.java)
                    runOnUiThread {
                        textViewLessons.text = lesson.title
                        textViewText.text = detail.text
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}