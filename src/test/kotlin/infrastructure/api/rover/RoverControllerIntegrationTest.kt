package infrastructure.api.rover

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
internal class RoverControllerIntegrationTest {

    protected lateinit var mockMvc: MockMvc

    @Autowired
    private val context: WebApplicationContext? = null

    @BeforeEach
    @Throws(Exception::class)
    fun init() {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(context!!)
            .apply<DefaultMockMvcBuilder>(SecurityMockMvcConfigurers.springSecurity())
            .build()
    }

    @Test
    fun `should return 200 when turning rover successfully`() {

        mockMvc.perform(
            post("/turn")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """{
                    |"action": "turn",
                    |"command": "l"
                    |}""".trimMargin()
                )
        ).andExpect(status().isOk)
    }
}
