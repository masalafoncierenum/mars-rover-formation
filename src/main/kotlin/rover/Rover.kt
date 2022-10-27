package rover

import command.Command
import position.Direction
import position.Point

data class Rover(val point: Point, var direction: Direction) {
    fun turn(rotation: String) {
        if (rotation == "l") {
            this.direction = this.direction.turnLeft()
        }
        else{
            this.direction = this.direction.turnRight()
        }
    }

    fun receiveCommand(command: Command) {
        return turn(command.parameter)
    }

}
