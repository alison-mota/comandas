package com.comandas.comandas.clientes

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
class Cliente(
    @field:NotBlank val nome: String,
    val telefone: String,
//    val empresa: Empresa,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}