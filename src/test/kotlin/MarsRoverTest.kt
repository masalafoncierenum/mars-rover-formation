import org.junit.jupiter.api.Test
import rover.Rover

class MarsRoverTest {
    @Test
    fun `should create a rover`() {
        val x = 1
        val y = 1
        val direction = "north"
        val rover = Rover(x,y,direction)

        assertThat()
    }
}