package group2.domain.rover

import group2.domain.move.Move
import group2.domain.command.Command
import group2.domain.position.Direction
import group2.domain.position.Point
import group2.domain.position.TurningDirection

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
