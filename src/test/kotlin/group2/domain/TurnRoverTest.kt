package group2.domain

import group2.domain.application.command.TurnRover
import group2.domain.command.Command
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import group2.domain.position.Direction
import group2.domain.position.Point
import group2.domain.rover.Rover
import group2.domain.rover.RoverRepository

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
