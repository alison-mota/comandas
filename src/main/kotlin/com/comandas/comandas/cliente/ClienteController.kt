package com.comandas.comandas.cliente

import com.comandas.comandas.utils.URL_V1_CLIENTE
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping(URL_V1_CLIENTE)
class ClienteController(
    private val clienteRepository: ClienteRepository
) {

    @PostMapping
    fun novo(
        @Valid @RequestBody clienteRequest: ClienteRequest,
        uriBuilder: UriComponentsBuilder
    ): Int {
        val cliente = clienteRequest.paraModelo()
        clienteRepository.save(cliente)
        return HttpStatus.OK.value()
    }
}