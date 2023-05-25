package network.exception

class FileExtensionNotProvidedException : NetworkErrorException(RuntimeException()) {

    companion object {
        private const val MESSAGE = "File extensions was not provided on the content header"
    }

    override val message: String
        get() = MESSAGE
}