package com.comandas.comandas.clientes

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private const val URL_V1_CLIENTE = "/v1/cliente"

@RestController
@RequestMapping(URL_V1_CLIENTE)
class Controller {

    @PostMapping
    fun novo(): Int {
        return HttpStatus.OK.value()
    }
}