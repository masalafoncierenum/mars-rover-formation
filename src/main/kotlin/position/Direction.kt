package position

enum class Direction {
    N,
    E,
    S,
    W;

    fun turnLeft(): Direction {
        val directions = Direction.values()
        val newOrdinal = (this.ordinal + directions.size - 1) % directions.size
        return directions[newOrdinal]
    }

    fun turnRight(): Direction {
        val directions = Direction.values()
        val newOrdinal = (this.ordinal + 1) % directions.size
        return directions[newOrdinal]
    }


}
