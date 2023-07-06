package com.nguyen.mockito2

import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ServiceTest {
    @Mock
    lateinit var mock: Database

    @Test
    fun testQuery() {
        assertNotNull(mock)
        `when`(mock.isAvailable()).thenReturn(true)
        assertTrue(Service(mock).query("* FROM table"))
    }
}