package com.example.testovoe22

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

class LessonsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LessonsAdapter
    private lateinit var activity: Activity
    private lateinit var vlevo: ImageView

    private lateinit var lessons: List<LessonsItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lessons)

        recyclerView = findViewById(R.id.recyclerView)
        vlevo = findViewById(R.id.vlevo)
        val verticalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = verticalLayoutManager
        activity = this
        vlevo.setOnClickListener {
            finish()
        }
        loadData()
    }

    private fun loadData() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val course = intent.getSerializableExtra("course") as? CoursesItem
                if (course != null) {
                    if (course.id == 1) {
                        val data = URL("http://135.181.248.237/22/lesson1.json").readText()
                        val gson = Gson()
                        lessons = gson.fromJson(data, Array<LessonsItem>::class.java).toList()
                        val sharedPreferences =
                            getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
                        for (lesson in lessons) {
                            if (sharedPreferences.getBoolean("${lesson.id}", false)==true) {
                                lesson.read = true
                            }
                        }
                        runOnUiThread {
                            adapter = LessonsAdapter(activity, lessons)
                            recyclerView.adapter = adapter
                        }
                    }
                    if (course.id == 2) {
                        val data = URL("http://135.181.248.237/22/lesson2.json").readText()
                        val gson = Gson()
                        lessons = gson.fromJson(data, Array<LessonsItem>::class.java).toList()
                        val sharedPreferences =
                            getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
                        for (lesson in lessons) {
                            if (sharedPreferences.getBoolean("${lesson.id}", false)==true) {
                                lesson.read = true
                            }
                        }
                        runOnUiThread {
                            adapter = LessonsAdapter(activity, lessons)
                            recyclerView.adapter = adapter
                        }
                    }
                    if (course.id == 3) {
                        val data = URL("http://135.181.248.237/22/lesson3.json").readText()
                        val gson = Gson()
                        lessons = gson.fromJson(data, Array<LessonsItem>::class.java).toList()
                        val sharedPreferences =
                            getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
                        for (lesson in lessons) {
                            if (sharedPreferences.getBoolean("${lesson.id}", false)==true) {
                                lesson.read = true
                            }
                        }
                        runOnUiThread {
                            adapter = LessonsAdapter(activity, lessons)
                            recyclerView.adapter = adapter
                        }
                    }
                    if (course.id == 4) {
                        val data = URL("http://135.181.248.237/22/lesson4.json").readText()
                        val gson = Gson()
                        lessons = gson.fromJson(data, Array<LessonsItem>::class.java).toList()
                        val sharedPreferences =
                            getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
                        for (lesson in lessons) {
                            if (sharedPreferences.getBoolean("${lesson.id}", false)==true) {
                                lesson.read = true
                            }
                        }
                        runOnUiThread {
                            adapter = LessonsAdapter(activity, lessons)
                            recyclerView.adapter = adapter
                        }
                    }
                    if (course.id == 5) {
                        val data = URL("http://135.181.248.237/22/lesson5.json").readText()
                        val gson = Gson()
                        lessons = gson.fromJson(data, Array<LessonsItem>::class.java).toList()
                        val sharedPreferences =
                            getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
                        for (lesson in lessons) {
                            if (sharedPreferences.getBoolean("${lesson.id}", false)==true) {
                                lesson.read = true
                            }
                        }
                        runOnUiThread {
                            adapter = LessonsAdapter(activity, lessons)
                            recyclerView.adapter = adapter
                        }
                    }
                    if (course.id == 6) {
                        val data = URL("http://135.181.248.237/22/lesson6.json").readText()
                        val gson = Gson()
                        lessons = gson.fromJson(data, Array<LessonsItem>::class.java).toList()
                        val sharedPreferences =
                            getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
                        for (lesson in lessons) {
                            if (sharedPreferences.getBoolean("${lesson.id}", false)==true) {
                                lesson.read = true
                            }
                        }
                        runOnUiThread {
                            adapter = LessonsAdapter(activity, lessons)
                            recyclerView.adapter = adapter
                        }
                    }
                    if (course.id == 7) {
                        val data = URL("http://135.181.248.237/22/lesson7.json").readText()
                        val gson = Gson()
                        lessons = gson.fromJson(data, Array<LessonsItem>::class.java).toList()
                        val sharedPreferences =
                            getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
                        for (lesson in lessons) {
                            if (sharedPreferences.getBoolean("${lesson.id}", false)==true) {
                                lesson.read = true
                            }
                        }
                        runOnUiThread {
                            adapter = LessonsAdapter(activity, lessons)
                            recyclerView.adapter = adapter
                        }
                    }
                    if (course.id == 8) {
                        val data = URL("http://135.181.248.237/22/lesson8.json").readText()
                        val gson = Gson()
                        lessons = gson.fromJson(data, Array<LessonsItem>::class.java).toList()
                        val sharedPreferences =
                            getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
                        for (lesson in lessons) {
                            if (sharedPreferences.getBoolean("${lesson.id}", false)==true) {
                                lesson.read = true
                            }
                        }
                        runOnUiThread {
                            adapter = LessonsAdapter(activity, lessons)
                            recyclerView.adapter = adapter
                        }
                    }
                    if (course.id == 9) {
                        val data = URL("http://135.181.248.237/22/lesson9.json").readText()
                        val gson = Gson()
                        lessons = gson.fromJson(data, Array<LessonsItem>::class.java).toList()
                        val sharedPreferences =
                            getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
                        for (lesson in lessons) {
                            if (sharedPreferences.getBoolean("${lesson.id}", false)==true) {
                                lesson.read = true
                            }
                        }
                        runOnUiThread {
                            adapter = LessonsAdapter(activity, lessons)
                            recyclerView.adapter = adapter
                        }
                    }
                    if (course.id == 10) {
                        val data = URL("http://135.181.248.237/22/lesson10.json").readText()
                        val gson = Gson()
                        lessons = gson.fromJson(data, Array<LessonsItem>::class.java).toList()
                        val sharedPreferences =
                            getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
                        for (lesson in lessons) {
                            if (sharedPreferences.getBoolean("${lesson.id}", false)==true) {
                                lesson.read = true
                            }
                        }
                        runOnUiThread {
                            adapter = LessonsAdapter(activity, lessons)
                            recyclerView.adapter = adapter
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}