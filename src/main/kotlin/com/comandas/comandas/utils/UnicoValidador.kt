package com.comandas.comandas.utils

import jakarta.persistence.EntityManager
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import kotlin.reflect.KClass

class UnicoValidador(private val manager: EntityManager) : ConstraintValidator<Unico, Any> {

    private var fieldName: String? = null
    private var entityClass: KClass<*>? = null

    override fun initialize(constraintAnnotation: Unico?) {
        this.entityClass = constraintAnnotation?.entityClass
        this.fieldName = constraintAnnotation?.fieldName
    }

    override fun isValid(value: Any?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) return true

        val jpql = "SELECT 1 FROM ${entityClass?.simpleName} e WHERE e.$fieldName = :value"
        val entities = manager
            .createQuery(jpql, Integer::class.java)
            .setParameter("value", value)
            .resultList

        return entities.isEmpty()
    }
}