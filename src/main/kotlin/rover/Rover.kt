package rover

import command.Command
import position.Direction
import position.Point

data class Rover(val point: Point, var direction: Direction) {
    fun turn(rotation: String) {
        this.direction = this.direction.turn(rotation)
    }

    fun receiveCommand(command: Command) {
        return turn(command.parameter)
    }

}
