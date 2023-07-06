package com.nguyen.mockito2

class Service(private val database: Database) {
    fun query(sql: String) = database.isAvailable()

    override fun toString() = "Using database with id ${database.uniqueId}"
}