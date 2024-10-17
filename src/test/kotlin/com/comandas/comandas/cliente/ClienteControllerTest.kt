package com.comandas.comandas.cliente

import com.comandas.comandas.utils.URL_V1
import com.comandas.comandas.utils.jsonClienteRequest200
import com.github.tomakehurst.wiremock.client.WireMock
import io.mockk.unmockkAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.*
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


class ClienteControllerTest {

    @MockBean
    private lateinit var clienteRepository: ClienteRepository


    @AfterEach
    fun configuracao() {
        unmockkAll()
    }

    @Nested
    @WebMvcTest
    inner class ClienteControllerIntegrationTests {
        @Autowired
        private lateinit var mockMvc: MockMvc

        @Test
        fun `deve cadastrar um cliente quando o endpoint for chamado`() {
            mockMvc.perform(
                post(URL_V1)
                    .content(jsonClienteRequest200)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
            )
                .andExpect(status().isOk)
        }
    }

    @Nested
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    inner class Temp {

        @Autowired
        private lateinit var restTemplate: TestRestTemplate

        @BeforeEach
        fun retornoMockado() {
            WireMock.stubFor(
                WireMock
                    .post(WireMock.urlEqualTo(URL_V1))
                    .willReturn(
                        WireMock.aResponse()
                            .withStatus(HttpStatus.OK.value())
                            .withBody(jsonClienteRequest200)
                    )
            )
        }

        @AfterEach
        fun unmockk() {
            unmockkAll()
        }

        @Test
        fun `deve cadastrar um cliente quando o endpoint for chamado`() {
            val headers = HttpHeaders()
            val temp = HttpEntity<String>(headers)
            val response = restTemplate.exchange(URL_V1, HttpMethod.POST, temp, String::class.java)

            val temp2 = "adfaf"
        }


    }
}