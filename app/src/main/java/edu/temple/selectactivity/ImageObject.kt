package edu.temple.selectactivity

class ImageObject (var description: String, val imageId: Int){
    operator fun get(index: Int): ImageObject {
        val imageArray = ImageObject(description, imageId)
        return imageArray[index]
    }

}

