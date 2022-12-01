package domain

import domain.application.command.TurnRover
import domain.command.Command
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import domain.position.Direction
import domain.position.Point
import domain.rover.Rover
import domain.rover.RoverRepository

@ExtendWith(MockKExtension::class)
internal class TurnRoverTest{

    @RelaxedMockK
    private lateinit var roverRepository: RoverRepository

    @InjectMockKs
    private lateinit var turnRover: TurnRover

    @Test
    internal fun `should turn rover`() {

        every { roverRepository.getRover()} returns Rover(Point(0,0),Direction.S)

        val commandLeftTurn = Command("turn", "l")

        val rover = turnRover.execute(commandLeftTurn)

        assertThat(rover.direction).isEqualTo(Direction.E)


    }
}
