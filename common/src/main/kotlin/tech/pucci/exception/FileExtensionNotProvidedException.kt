package tech.pucci.exception

class FileExtensionNotProvidedException : NetworkErrorException(Exception()) {

    companion object {
        private const val MESSAGE = "File extensions was not provided on the content header"
    }

    override val message: String
        get() = MESSAGE
}