package com.comandas.comandas.cliente

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class ClienteRequest(
    @field:NotBlank val nome: String,
    val telefone: String?,
    @Email val email: String?
) {
    fun paraModelo(): Cliente {
        return Cliente(
            nome = nome, telefone = telefone, email = email
        )
    }
}