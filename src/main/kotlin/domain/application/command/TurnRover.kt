package domain.application.command

import domain.command.Command
import domain.rover.Rover
import domain.rover.RoverRepository

class TurnRover (val roverRepository: RoverRepository) {

    fun execute(command: Command): Rover {
      val rover = roverRepository.getRover()
        rover.receiveCommand(command)
        return rover
    }

}
