package domain.rover

import domain.Move.Move
import domain.command.Command
import domain.position.Direction
import domain.position.Point
import domain.position.TurningDirection

data class Rover(var point: Point, var direction: Direction) {


    fun turn(rotation: TurningDirection) {
        this.direction = this.direction.turn(rotation)
    }

    fun receiveCommand(command: Command) {
        val turningDirection = TurningDirection.from(command.parameter)
        return turn(turningDirection)
    }

    fun move(move: Move): Rover {
        if (this.direction == Direction.N) this.point = this.point.copy(y=this.point.y+1)
        if (this.direction == Direction.S) this.point = this.point.copy(y=this.point.y-1)
        if (this.direction == Direction.E) this.point = this.point.copy(x=this.point.x+1)
        if (this.direction == Direction.W) this.point = this.point.copy(x=this.point.x-1)

        return this
    }

}
