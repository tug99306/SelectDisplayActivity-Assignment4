package edu.temple.selectactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager


class MainActivity : AppCompatActivity() {


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

            }

            recycler.layoutManager = GridLayoutManager(this,2)
            imageAdapter = ImageAdapter(this, imageArray){ imagesItem : ImageObject ->
                imageItemClicked(imagesItem)}
            recycler.adapter = imageAdapter
        }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }


    }

