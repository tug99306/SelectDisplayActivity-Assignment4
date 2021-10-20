package edu.temple.selectactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SelectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectionFragment : Fragment() {

    private  var imgArray : Array<ImageObject> = emptyArray()
    lateinit var recycler: RecyclerView

    lateinit var layout: View
    lateinit var viewModelProvider: ViewModelProvider
    var startupIndex : Int? = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startupIndex = arguments?.getInt("startupIndex", 0)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        layout = inflater.inflate(R.layout.fragment_selection, container, false)
        recycler = layout.findViewById(R.id.recyclerView)

        recycler.layoutManager = GridLayoutManager(requireContext(),2)


        recycler.adapter = ImageAdapter(requireContext(), imgArray){ imagesItem : ImageObject ->
            imageItemClicked(imagesItem)}

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelProvider = ViewModelProvider(requireActivity())

        changeImage(startupIndex)
    }
    fun changeImage(index: Int?) {
        if (index != null) {
            imageItemClicked(imgArray[index])
        }

    }

    fun imageItemClicked(images : ImageObject) {
        val name = images.description
        val img = (images.imageId)
        viewModelProvider.get(ImageViewModel::class.java).setImage(img)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SelectionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(images: Array<ImageObject>) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    imgArray = images
                }
            }
    }

}