package rover

import command.Command
import position.Direction
import position.Point
import position.TurningDirection

data class Rover(val point: Point, var direction: Direction) {
    fun turn(rotation: TurningDirection) {
        this.direction = this.direction.turn(rotation)
    }

    fun receiveCommand(command: Command) {
        val turningDirection = TurningDirection.from(command.parameter)
        return turn(turningDirection)
    }

}
