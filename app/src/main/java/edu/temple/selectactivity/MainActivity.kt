package edu.temple.selectactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import edu.temple.selectactivity.ImageAdapter
import edu.temple.selectactivity.ImageObject


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageAdapter: ImageAdapter
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val nameTextView = findViewById<TextView>(R.id.nameText)
        val displayImageView = findViewById<ImageView>(R.id.displayImageView)

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
            nameTextView.text = images.description
            displayImageView.setImageResource(images.imageId)
        }

        recycler.layoutManager = GridLayoutManager(this,2)
        imageAdapter = ImageAdapter(this, imageArray){ imagesItem : ImageObject ->
            imageItemClicked(imagesItem)}
        recycler.adapter = imageAdapter





}

}