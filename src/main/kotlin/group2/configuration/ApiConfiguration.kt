package group2.configuration

import group2.infrastructure.api.rover.RoverAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApiConfiguration {

    @Bean
    fun roverAdapter()  = RoverAdapter()
}