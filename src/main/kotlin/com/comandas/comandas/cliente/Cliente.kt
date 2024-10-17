package com.comandas.comandas.cliente

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

@Entity
class Cliente(
    @field:NotBlank val nome: String,
    val telefone: String?,
    @Email val email: String?,
//    val empresa: Empresa,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}