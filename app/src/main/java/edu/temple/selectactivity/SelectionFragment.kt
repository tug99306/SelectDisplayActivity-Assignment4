package edu.temple.selectactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionFragment : Fragment() {
    lateinit var recycler: RecyclerView
    lateinit var layout: View

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

    var startupIndex: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startupIndex = arguments?.getInt("startupIndex", 0)
    }
    fun imageItemClicked(images : ImageObject) {
        val name = images.description
        val img = (images.imageId)
        (requireActivity() as MyInterface).imageSelected(images, img)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_selection, container, false)

        recycler.layoutManager = GridLayoutManager(requireContext(),2)

        recycler.adapter = ImageAdapter(
            requireContext(), imageArray){ imagesItem : ImageObject ->
            imageItemClicked(imagesItem)}

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeImage(imageArray, startupIndex)
    }

    fun changeImage(images: Array<ImageObject>, index: Int?) {
        if (index != null) {
            imageItemClicked(images[index])
        }
    }

    companion object {
        fun getInstance(index: Int): SelectionFragment {
            val fragment = SelectionFragment()
            val bundle: Bundle = Bundle()
            bundle.putInt("startupIndex", index)
            fragment.arguments = bundle
            return fragment
        }
    }

    interface MyInterface {
        fun imageSelected(images: ImageObject, imageId: Int)
    }
}