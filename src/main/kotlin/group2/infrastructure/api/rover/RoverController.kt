package group2.infrastructure.api.rover

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RoverController(val roverAdapter: RoverAdapter) {

    @PostMapping("/turn")
    fun turn(@RequestBody commandRequest : CommandRequest) : ResponseEntity<RoverView> {
        return ResponseEntity.ok(roverAdapter.turn(commandRequest))
    }
}