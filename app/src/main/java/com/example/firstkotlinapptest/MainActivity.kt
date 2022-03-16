package com.example.firstkotlinapptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //a lateinit var is what you use to tell the compiler that you will initialize the variable later so it doesn't complain
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //A mutablelistOf() is just an empty list
        todoAdapter = TodoAdapter(mutableListOf())

        //Linking the adapter class to the adapter of the recycler view
        rvTodoItems.adapter = todoAdapter

        //Assigning Layout Manager to recycler view
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        //
        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()

            if(todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }

        btnDelete.setOnClickListener {
            todoAdapter.deleteDoneTodo()
        }

    }
}