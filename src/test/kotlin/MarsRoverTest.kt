import org.junit.jupiter.api.Test
import rover.Rover
import org.assertj.core.api.Assertions.assertThat
import point.Point


class MarsRoverTest {
    @Test
    fun `should create a rover facing north`() {
        val point = Point(1,1)
        val direction = "north"
        val rover = Rover(point,direction)

        assertThat(rover.point).isEqualTo(Point(1,1))
        assertThat(rover.direction).isEqualTo("north")

    }

    @Test
    fun `should create a rover facing south`() {
        val point = Point(1,1)
        val direction = "south"
        val rover = Rover(point,direction)

        assertThat(rover.point).isEqualTo(Point(1,1))
        assertThat(rover.direction).isEqualTo("south")

    }

    @Test
    fun `should create a rover facing east`() {
        val point = Point(1,1)
        val direction = "east"
        val rover = Rover(point,direction)

        assertThat(rover.point).isEqualTo(Point(1,1))
        assertThat(rover.direction).isEqualTo("east")

    }
    @Test
    fun `should create a rover facing west`() {
        val point = Point(1,1)
        val direction = "west"
        val rover = Rover(point,direction)

        assertThat(rover.point).isEqualTo(Point(1,1))
        assertThat(rover.direction).isEqualTo("west")

    }
}
