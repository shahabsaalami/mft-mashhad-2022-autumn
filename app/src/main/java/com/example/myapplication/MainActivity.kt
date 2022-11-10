package com.example.myapplication

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "Coroutine"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//         threadLearning()
//        coroutines()
//        runBlock()
        coroutineLearing()

    }

    private fun coroutineLearing() {
        val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")

        repeat(3){
            GlobalScope.launch {
                Log.i(TAG, "${Thread.currentThread()} has started")
                for (i in states){
                    Log.d(TAG, "${Thread.currentThread()} - $i")
                    Thread.sleep(50)
                }
            }
        }

    }

    private fun runBlock() {

        runBlocking {
            Log.d(TAG, "runBlock: 1")
            val num1 = async {  getValue()}
            val num2 =async { getValue() }
            Log.d(TAG, "runBlock: 2")
            Log.w(TAG, "3 result of num1 + num2 is ${num1.await() + num2.await()}", )
            Log.i(TAG, "4 runBlock: ")
        }
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

    private fun coroutines() {

        repeat(10) {
            val job: Job = GlobalScope.launch {
                Log.d(TAG, "coroutines: ${Thread.currentThread()}")
            }
        }

    }

    val formatter: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME
    val time = {formatter.format(LocalDateTime.now())}

    suspend fun getValue(): Double {
        Log.i(TAG, "entering getValue at ${time()} ")
        delay(3000)
        Log.i(TAG,"leaving getValue() at ${time()}")
        return Math.random()
    }
}
