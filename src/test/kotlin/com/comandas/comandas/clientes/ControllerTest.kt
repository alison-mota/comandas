package com.comandas.comandas.clientes

import com.comandas.comandas.util.URI_V1_CLIENTE
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class ControllerTest(

) {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `deve cadastrar um cliente quando o endpoint for chamado`() {

        mockMvc
            .perform(post(URI_V1_CLIENTE))
            .andExpect(status().isOk)
    }
}