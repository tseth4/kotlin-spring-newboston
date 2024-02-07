package tc.codealong.tutorials.springboot.thenewboston.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest {
    //  lateinit keyword is used to declare a non-null property that will be initialized later, before you use it.
    // MockMvc class is typically used in Spring MVC testing to perform requests and validate responses without starting a full web server.
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should return all banks`() {
        mockMvc.get("/api/banks")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[0].accountNumber") {
                    value("12345")
                }
            }
    }

    @Test
    fun `should return bank with given account number`() {
        val accountNumber = 1234
        mockMvc.get("/api/banks/$accountNumber")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.trust") {
                    value("0.0")
                }
                jsonPath("$.transactionFee") {
                    value("100")
                }
            }
    }
}