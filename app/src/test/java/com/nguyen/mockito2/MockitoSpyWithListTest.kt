package com.nguyen.mockito2

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.spy
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner
import java.util.LinkedList

@RunWith(MockitoJUnitRunner::class)
class MockitoSpyWithListTest {
    @Spy
    var spy: List<String> = LinkedList()

    @Before
    fun setup() {
        // Alternative way of creating a spy
        // List<String> list = new LinkedList<>();
        // List<String> spy = spy(list);
    }

    @Test
    fun testLinkedListSpyCorrect() {
        // when(spy.get(0)).thenReturn("foo");
        // would not work as the delegate it called so spy.get(0)
        // throws IndexOutOfBoundsException (list is still empty)

        // you have to use doReturn() for stubbing
        doReturn("foo").`when`(spy)[0]
        assertEquals("foo", spy[0])
    }

    // demonstrates of the spy function
    @Test
    open fun ensureSpyForListWorks() {
        val list = ArrayList<String>()
        val spiedList = spy(list)
        doReturn("42").`when`(spiedList)[99]
        val value = spiedList[99] as String
        assertEquals("42", value)
    }
}