package group2.domain.application.command

import group2.domain.command.Command
import group2.domain.rover.Rover
import group2.domain.rover.RoverRepository

class TurnRover (val roverRepository: RoverRepository) {

    fun execute(command: Command): Rover {
      val rover = roverRepository.getRover()
        rover.receiveCommand(command)
        return rover
    }

}
