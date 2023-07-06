package com.nguyen.mockito2

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ServiceDatabaseIdTest {
    @Mock
    lateinit var mock: Database

    @Test
    fun ensureMockitoReturnsTheConfiguredValue() {
        `when`(mock.uniqueId).thenReturn(42)
        assertEquals(Service(mock).toString(), "Using database with id 42")
    }
}
