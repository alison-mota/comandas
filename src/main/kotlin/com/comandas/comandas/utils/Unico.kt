package com.comandas.comandas.utils

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [UnicoValidador::class])
@MustBeDocumented
annotation class Unico(
    val message: String = "Já existe um objeto com esse atributo no banco de dados",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = [],
    val fieldName: String,
    val entityClass: KClass<*>
)
