package group2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RoverMain {
    fun main(args: Array<String>) {
        runApplication<RoverMain>(*args)
    }
}