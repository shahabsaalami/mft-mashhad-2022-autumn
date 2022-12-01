package com.example.myapplication.workers

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.myapplication.KEY_IMAGE_URI

private val TAG = "BlurWorker"

class BlurWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {

    override fun doWork(): Result {
        val appContext = applicationContext
        val resourceUri = inputData.getString(KEY_IMAGE_URI)
        sleep()

        makeStatusNotification("Bluring image", appContext)

        return try {
//            val picture = BitmapFactory.decodeResource(
//                appContext.resources,
//                R.drawable.android_cupcake)
            if (TextUtils.isEmpty(resourceUri)) {
                Log.e(TAG, "Input is invalid ")
                throw IllegalArgumentException("Input is invalid ")
            }
            val resolver = appContext.contentResolver
            val picture = BitmapFactory.decodeStream(
                resolver.openInputStream(Uri.parse(resourceUri))
            )
            val output = blurBitmap(picture, appContext)
            // Write bitmap to a temp file
            val outputUri = writeBitmapToFile(appContext, output)
            makeStatusNotification("Output is $outputUri", appContext)
            val outputData = workDataOf(KEY_IMAGE_URI to outputUri.toString())

            Result.success(outputData)
        } catch (e: Throwable) {
            Log.e(TAG, "Error applying blur", e)
            Result.failure()
        }

    }
}