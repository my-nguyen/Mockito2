package com.nguyen.mockito2

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.atLeast
import org.mockito.Mockito.atLeastOnce
import org.mockito.Mockito.never
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MockitoVerifyTest {
    @Mock
    lateinit var database: Database

    @Test
    fun testVerify() {
        // create and configure mock
        `when`(database.uniqueId).thenReturn(43)

        // call method testing on the mock with parameter 12
        database.uniqueId = 12
        database.uniqueId
        database.uniqueId

        // now check if method testing was called with the parameter 12
        verify(database).uniqueId = ArgumentMatchers.eq(12)

        // was the method called twice?
        verify(database, times(2)).uniqueId

        // other alternatives for verifiying the number of method calls for a method
        verify(database, never()).isAvailable()
        verify(database, never()).uniqueId = 13
        verify(database, atLeastOnce()).uniqueId = 12
        verify(database, atLeast(2)).uniqueId

        // more options are
        // times(numberOfTimes)
        // atMost(numberOfTimes)
        // This let's you check that no other methods where called on this object.
        // You call it after you have verified the expected method calls.
        verifyNoMoreInteractions(database)
    }
}