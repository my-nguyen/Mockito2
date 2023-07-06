package com.nguyen.mockito2

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.isA
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MockitoWhenExampleTest {
    @Mock
    lateinit var iterator: Iterator<String>
    @Mock
    lateinit var comparableString: Comparable<String>
    @Mock
    lateinit var comparableInt: Comparable<Int>

    // demonstrates the return of multiple values
    @Test
    fun testMoreThanOneReturnValue() {
        `when`(iterator.next()).thenReturn("Mockito").thenReturn("rocks")

        assertEquals("Mockito rocks", "${iterator.next()} ${iterator.next()}")
    }

    // demonstrates how to return values based on the input
    @Test
    fun testReturnValueDependentOnMethodParameter() {
        `when`(comparableString.compareTo("Mockito")).thenReturn(1)
        `when`(comparableString.compareTo("Eclipse")).thenReturn(2)

        assertEquals(1, comparableString.compareTo("Mockito"))
        assertEquals(2, comparableString.compareTo("Eclipse"))
    }

    // return a value based on the type of the provide parameter
    @Test
    fun testReturnValueInDependentOnMethodParameter2() {
        `when`(comparableInt.compareTo(isA(Int::class.java))).thenReturn(0)

        assertEquals(0, comparableInt.compareTo(Integer.valueOf(4)))
    }
}