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
                ImageObject(resources.getStringArray(R.array.bird_array)[0], R.drawable.eagle)
                , ImageObject(resources.getStringArray(R.array.bird_array)[1], R.drawable.hawk)
                , ImageObject(resources.getStringArray(R.array.bird_array)[2], R.drawable.lovebird)
                , ImageObject(resources.getStringArray(R.array.bird_array)[3], R.drawable.owlstellatu)
                , ImageObject(resources.getStringArray(R.array.bird_array)[4], R.drawable.parakeet)
                , ImageObject(resources.getStringArray(R.array.bird_array)[5], R.drawable.parrot)
                , ImageObject(resources.getStringArray(R.array.bird_array)[6], R.drawable.penguin)
                , ImageObject(resources.getStringArray(R.array.bird_array)[7], R.drawable.puffin)
                , ImageObject(resources.getStringArray(R.array.bird_array)[8], R.drawable.strawberryfinch)
                , ImageObject(resources.getStringArray(R.array.bird_array)[9], R.drawable.turtledove)
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

