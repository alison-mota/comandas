package com.comandas.comandas.empresa

import com.comandas.comandas.utils.Unico
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.br.CNPJ

data class EmpresaRequest(
    @field:NotBlank val razaoSocial: String,
    val nomeFantasia: String?,
    @field:CNPJ @field:Unico(fieldName = "cnpj", entityClass = Empresa::class) val cnpj: String?,
    val telefone: String?
)