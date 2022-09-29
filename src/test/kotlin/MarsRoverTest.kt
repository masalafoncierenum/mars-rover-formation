import org.junit.jupiter.api.Test
import rover.Rover
import org.assertj.core.api.Assertions.assertThat




class MarsRoverTest {
    @Test
    fun `should create a rover`() {
        val x = 1
        val y = 1
        val direction = "north"
        val rover = Rover(x,y,direction)

        assertThat(rover.x).isEqualTo(1)
        assertThat(rover.y).isEqualTo(1)
        assertThat(rover.direction).isEqualTo("north")

    }
}
