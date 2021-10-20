package edu.temple.selectactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager


class MainActivity : AppCompatActivity(), SelectionFragment.MyInterface {
    lateinit var selectFragment: SelectionFragment
    lateinit var displayFragment: DisplayFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectFragment = SelectionFragment.getInstance(1)
        displayFragment = DisplayFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_selection, selectFragment)
            .add(R.id.fragment_display, displayFragment)
            .commit()

        //fragment1.changeColor(4)



    }

    fun myFunction() {

    }


    override fun imageSelected(images: ImageObject, imageId: Int) {
        displayFragment.changeImage(images, imageId)
    }


}

