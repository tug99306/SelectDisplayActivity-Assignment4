package edu.temple.selectactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        val titleTextView = findViewById<TextView>(R.id.textViewText)
        val imgView = findViewById<ImageView>(R.id.imageViewDisplay)

        val imgDesc = intent.getStringExtra("DESCRIPTION")
        val imgId = intent.getIntExtra("IMAGE_ID",0)



        // Create an intent to pass information to calling activity
        val resultIntent = Intent().putExtra("resultValue", "Second activity closed with Back button")
        setResult(RESULT_OK, resultIntent)

        titleTextView.text = imgDesc
        imgView.setImageResource(imgId)

        findViewById<Button>(R.id.buttonClose).setOnClickListener {

            // Replace Extra information in intent
            resultIntent.putExtra("resultValue", "Second activity closed with finish()")
            // Set code and data for returned result
            setResult(RESULT_OK, resultIntent)
            // Close activity
            finish()
        }



    }
}