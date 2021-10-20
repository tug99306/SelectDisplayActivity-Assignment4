package edu.temple.selectactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageViewModel : ViewModel(){
    private var images = MutableLiveData<ImageObject>()

    fun getImages () : LiveData<ImageObject> {
        return images
    }

    fun setImage (_image: Int) {
        images.value?.imageId  = _image
    }


}