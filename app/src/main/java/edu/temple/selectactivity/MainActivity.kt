package edu.temple.selectactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import edu.temple.selectactivity.ImageAdapter
import edu.temple.selectactivity.ImageObject


class MainActivity : AppCompatActivity() {

    val secondActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        Log.d("Returned data", it.data?.getStringExtra("resultValue").toString())
    }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            val secondActivityIntent = Intent(this, DisplayActivity::class.java)

            val imageAdapter: ImageAdapter
            val recycler = findViewById<RecyclerView>(R.id.recycler)

            val imageArray = arrayOf(
                ImageObject("Eagle", R.drawable.eagle)
                , ImageObject("Hawk", R.drawable.hawk)
                , ImageObject("Lovebird", R.drawable.lovebird)
                , ImageObject("Stella the Owl", R.drawable.owlstellatu)
                , ImageObject("Parakeet", R.drawable.parakeet)
                , ImageObject("Parrot", R.drawable.parrot)
                , ImageObject("Penguin", R.drawable.penguin)
                , ImageObject("Puffin", R.drawable.puffin)
                , ImageObject("Strawberry Finch", R.drawable.strawberryfinch)
                , ImageObject("Turtle Dove", R.drawable.turtledove)
            )
            fun imageItemClicked(images : ImageObject) {
                val name = images.description
                val img = (images.imageId)
                secondActivityIntent.putExtra("DESCRIPTION", name)
                secondActivityIntent.putExtra("IMAGE_ID", img)
                startActivity(secondActivityIntent)
                //secondActivityLauncher.launch(secondActivityIntent)

            }

            recycler.layoutManager = GridLayoutManager(this,2)
            imageAdapter = ImageAdapter(this, imageArray){ imagesItem : ImageObject ->
                imageItemClicked(imagesItem)}
            recycler.adapter = imageAdapter
        }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Overriding onRestoreInstanceState() allows you to separate your "initialization" code
        // from your "restoration" code.
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // This method is used to persist state data before the activity is destroyed by Android,
        // allowing it to be retrieved when the activity is recreated.
        // Please items in the Bundle argument and they will be returned when onCreate() and
        // onRestoreInstanceState() are called.
        //
    }

    override fun onStart() {
        super.onStart()
        Log.d("Main activity state", "onStart() fired")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Main activity state", "onResume() fired")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Main activity state", "onPause() fired")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Main activity state", "onStop() fired")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main activity state", "onDestroy() fired")
    }

    }

