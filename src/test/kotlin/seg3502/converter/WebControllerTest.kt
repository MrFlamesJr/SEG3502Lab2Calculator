package seg3502.calculator

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest
class WebControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun request_to_home() {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.view().name("home"))
    }

    @Test
    fun calculator_test() {
        //TODO: Implement the test for the calculator functionality
        // mockMvc.perform(
        //     MockMvcRequestBuilders.get("/calculate")
        //         .param("celsius", "0")
        //         .param("fahrenheit", "")
        //         .param("operation", "CtoF")
        // )
        //     .andExpect(MockMvcResultMatchers.status().isOk)
        //     .andExpect(MockMvcResultMatchers.model().attributek. ("fahrenheit", "32.00"))
        //     .andExpect(MockMvcResultMatchers.view().name("home"))
    }
}
