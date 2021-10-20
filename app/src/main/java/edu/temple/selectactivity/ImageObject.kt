package edu.temple.selectactivity

class ImageObject (var description: String, var imageId: Int){
    operator fun get(index: Int): ImageObject {
        val imageArray = ImageObject(description, imageId)
        return imageArray[index]
    }


}

