package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        threadLearning()

    }

    private fun threadLearning() {
        val thread = Thread {
            //the thread's name, priority, and thread group
            //Thread[Thread-4,5,main] has run
            Log.w(TAG, "${Thread.currentThread()} has run ")
        }
        thread.start()
        val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
        repeat(3) {
            Thread {
                Log.i(TAG, "${Thread.currentThread()} has started")
                for (i in states) {
                    Log.d(TAG, "${Thread.currentThread()} - $i")
                    Thread.sleep(50)
                }
            }.start()
        }

        var count = 0
        for (i in 1..50) {

            Thread() {
                count += 1
                Log.i(TAG, "Thread: i=$i count: $count")
            }.start()
        }

    }
}