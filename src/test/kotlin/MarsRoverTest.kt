import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import position.Direction.*
import position.Point
import rover.Rover


class MarsRoverTest {

    @Nested
    inner class Initialization {

        private val point = Point(1, 1)

        @Test
        fun `should create a rover facing north`() {
            val rover = Rover(point, N)

            assertThat(rover.point).isEqualTo(Point(1, 1))
            assertThat(rover.direction).isEqualTo(N)
        }

        @Test
        fun `should create a rover facing south`() {
            val rover = Rover(point, S)

            assertThat(rover.point).isEqualTo(Point(1, 1))
            assertThat(rover.direction).isEqualTo(S)
        }

        @Test
        fun `should create a rover facing east`() {
            val rover = Rover(point, E)

            assertThat(rover.point).isEqualTo(Point(1, 1))
            assertThat(rover.direction).isEqualTo(E)
        }

        @Test
        fun `should create a rover facing west`() {
            val rover = Rover(point, W)

            assertThat(rover.point).isEqualTo(Point(1, 1))
            assertThat(rover.direction).isEqualTo(W)
        }
    }

    @Nested
    inner class Rotation {
        private val point = Point(1, 1)

        @Test
        fun `should rotate left from north`() {
            val rover = Rover(point, N)

            rover.turn("l")

            assertThat(rover.direction).isEqualTo(W)
        }

        @Test
        fun `should rotate right from north`() {
            val rover = Rover(point, N)

            rover.turn("r")

            assertThat(rover.direction).isEqualTo(E)
        }
    }
}
