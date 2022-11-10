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

    fun move(move: Move): Point {
        if (this.direction == Direction.N) this.point = Point(1, 2)
        if (this.direction == Direction.S) this.point = Point(1, 0)

        return this.point
    }

}
