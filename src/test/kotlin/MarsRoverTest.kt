import command.Command
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import position.Direction.*
import position.Point
import rover.Rover


class MarsRoverTest {

    private val initialPoint = Point(1, 1)
    @Nested
    inner class Initialization {

        @Test
        fun `should create a rover facing north`() {
            val rover = Rover(initialPoint, N)

            assertThat(rover.point).isEqualTo(Point(1, 1))
            assertThat(rover.direction).isEqualTo(N)
        }

        @Test
        fun `should create a rover facing south`() {
            val rover = Rover(initialPoint, S)

            assertThat(rover.point).isEqualTo(Point(1, 1))
            assertThat(rover.direction).isEqualTo(S)
        }

        @Test
        fun `should create a rover facing east`() {
            val rover = Rover(initialPoint, E)

            assertThat(rover.point).isEqualTo(Point(1, 1))
            assertThat(rover.direction).isEqualTo(E)
        }

        @Test
        fun `should create a rover facing west`() {
            val rover = Rover(initialPoint, W)

            assertThat(rover.point).isEqualTo(Point(1, 1))
            assertThat(rover.direction).isEqualTo(W)
        }
    }

    @Nested
    inner class Rotation {


        @Test
        fun `should rotate left from north`() {
            val rover = Rover(initialPoint, N)

            rover.turn("l")

            assertThat(rover.direction).isEqualTo(W)
        }

        @Test
        fun `should rotate right from north`() {
            val rover = Rover(initialPoint, N)

            rover.turn("r")

            assertThat(rover.direction).isEqualTo(E)
        }

        @Test
        fun `should rotate right from west`() {
            val rover = Rover(initialPoint, W)

            rover.turn("r")

            assertThat(rover.direction).isEqualTo(N)
        }
    }

    @Nested
    inner class CommandReading {
        @Test
        fun `should rotate with command`() {
            val rover = Rover(initialPoint, N)
            val expectedDirection = rover.direction.turnLeft()
            val commandLeftTurn = Command("turn", "l")

            rover.receiveCommand(commandLeftTurn)

            assertThat(rover.direction).isEqualTo(expectedDirection)
        }

    }
}
