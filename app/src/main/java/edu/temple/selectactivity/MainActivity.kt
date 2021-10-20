package edu.temple.selectactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager


class MainActivity : AppCompatActivity() {
    lateinit var selectFragment: SelectionFragment
    lateinit var  displayFragment: DisplayFragment


    override fun onCreate(savedInstanceState: Bundle?) {

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

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        selectFragment = SelectionFragment.newInstance(imageArray)
        displayFragment = DisplayFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.container1,selectFragment)
            .add(R.id.container2, displayFragment)
            .commit()


    }



}

