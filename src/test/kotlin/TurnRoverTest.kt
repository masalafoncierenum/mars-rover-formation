import command.Command
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TurnRoverTest{

    private val turnRover = TurnRover()

    @Test
    internal fun `should turn rover`() {
        val commandLeftTurn = Command("turn", "l")

        val rover = turnRover.execute(commandLeftTurn)

        assert()


    }
}
