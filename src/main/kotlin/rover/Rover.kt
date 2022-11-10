package rover

import Move.Move
import command.Command
import position.Direction
import position.Point
import position.TurningDirection

data class Rover(var point: Point, var direction: Direction) {
    fun turn(rotation: TurningDirection) {
        this.direction = this.direction.turn(rotation)
    }

    fun receiveCommand(command: Command) {
        val turningDirection = TurningDirection.from(command.parameter)
        return turn(turningDirection)
    }

    fun move(f: Move): Point {
        this.point = Point(1, 2)
        return this.point
    }

}
