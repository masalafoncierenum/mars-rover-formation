import Move.Move
import command.Command
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import position.Direction.*
import position.Point
import position.TurningDirection
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

            rover.turn(TurningDirection.LEFT)

            assertThat(rover.direction).isEqualTo(W)
        }

        @Test
        fun `should rotate right from north`() {
            val rover = Rover(initialPoint, N)

            rover.turn(TurningDirection.RIGHT)

            assertThat(rover.direction).isEqualTo(E)
        }

        @Test
        fun `should rotate right from west`() {
            val rover = Rover(initialPoint, W)

            rover.turn(TurningDirection.RIGHT)

            assertThat(rover.direction).isEqualTo(N)
        }
    }

    @Nested
    inner class CommandReading {
        @Test
        fun `should turn left with command`() {
            val rover = Rover(initialPoint, N)
            val expectedDirection = rover.direction.turn(TurningDirection.LEFT)
            val commandLeftTurn = Command("turn", "l")

            rover.receiveCommand(commandLeftTurn)

            assertThat(rover.direction).isEqualTo(expectedDirection)
        }

        @Test
        fun `should turn right with command`() {
            val rover = Rover(initialPoint, N)
            val expectedDirection = rover.direction.turn(TurningDirection.RIGHT)
            val commandRightTurn = Command("turn", "r")

            rover.receiveCommand(commandRightTurn)

            assertThat(rover.direction).isEqualTo(expectedDirection)
        }

    }

    @Nested
    inner class Movement {

        @Test
        internal fun `should move forward the rover from North with a given position`() {
            val rover = Rover(initialPoint, N)

            rover.move(Move.F)

            assertThat(rover.point).isEqualTo(Point(1,2))
        }

        @Test
        internal fun `should move forward the rover from South`() {
            val rover = Rover(initialPoint, S)

            rover.move(Move.F)

            assertThat(rover.point).isEqualTo(Point(1,0))
        }

        @ParameterizedTest
        @CsvSource("1,2,N")
        internal fun `should move forward the rover`(x: Int, y: Int, direction: String) {
            val rover = Rover(initialPoint, valueOf(direction))

            rover.move(Move.F)

            assertThat(rover.point).isEqualTo(Point(x,y))
        }
    }
}
