package infrastructure.api.rover

data class CommandRequest(
    val command : String,
    val action: String
)
