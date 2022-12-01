package group2.domain.position

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

    fun turn(parameter: TurningDirection): Direction {
        return if (parameter == TurningDirection.RIGHT) {
            turnRight()
        } else {
            turnLeft()
        }
    }
}

enum class TurningDirection(val value: String) {
    RIGHT("r"),
    LEFT("l"),
    UNKNOWN("UNKNOWN");

    companion object {
        fun from(value: String) : TurningDirection {
            return values().find {
                it.value == value
            }?: UNKNOWN;
        }
    }
}
