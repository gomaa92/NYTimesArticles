package com.gomaa.nytimesarticles.features.populararticles.presentation.utils

import android.content.Context
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class UtilsTest {

    @Test
    fun `initializeFilterOptions returns correct list of options`() {
        // When
        val options = initializeFilterOptions()

        // Then
        assertEquals(3, options.size)

        assertTrue(options[0].isSelected)
        assertEquals(1, options[0].period)

        assertFalse(options[1].isSelected)
        assertEquals(7, options[1].period)

        assertFalse(options[2].isSelected)
        assertEquals(30, options[2].period)
    }

    private fun assertFalse(boolean: Boolean) = assertTrue(!boolean)
}