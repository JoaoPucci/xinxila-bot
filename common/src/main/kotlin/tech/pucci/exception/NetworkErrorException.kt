package tech.pucci.exception

open class NetworkErrorException(exception: Exception) : Exception(exception) {

    companion object {
        private const val DEFAULT_ERROR_IMAGE_URL = "https://pbs.twimg.com/media/EVnLUwbWAAMArdj.jpg"
    }

    val errorImageUrl: String
        get() = DEFAULT_ERROR_IMAGE_URL
}