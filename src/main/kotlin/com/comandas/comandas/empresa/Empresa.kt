package com.comandas.comandas.empresa

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.br.CNPJ

@Entity
class Empresa(
    @field:NotBlank val razaoSocial: String,
    val nomeFantasia: String?,
    @field:CNPJ val cnpj: String?,
    val telefone: String?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}