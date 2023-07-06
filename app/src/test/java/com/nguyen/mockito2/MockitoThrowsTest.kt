package com.nguyen.mockito2

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.doThrow
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.util.Properties


@RunWith(MockitoJUnitRunner::class)
class MockitoThrowsTest {
    // demonstrates the configuration of a throws with Mockito
    // not a read test, just "testing" Mockito behavior
    @Test
    fun testMockitoThrows() {
        val properties = Mockito.mock(Properties::class.java)
        `when`(properties[Mockito.anyString()]).thenThrow(IllegalArgumentException("Stuff"))

        val exception = assertThrows(IllegalArgumentException::class.java) { properties["A"] }
        assertEquals("Stuff", exception.message)
    }

    @Test
    @Throws(IOException::class)
    fun testForIOException() {
        // create an configure mock
        val mockStream = mock(OutputStream::class.java)
        doThrow(IOException()).`when`(mockStream).close()

        // use mock
        val streamWriter = OutputStreamWriter(mockStream)
        assertThrows(IOException::class.java) {
            streamWriter.close()
        }
    }
}