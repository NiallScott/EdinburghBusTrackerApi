/*
 * Copyright 2022 Niall Scott
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.org.rivernile.edinburghbustrackerapi

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

/**
 * Tests for [FaultCode].
 */
class FaultCodeTest {

    @Test
    fun invalidAppKeyFaultCodeReturnsCorrectEnumValue() {
        val result = FaultCode.convertFromString("INVALID_APP_KEY")

        assertEquals(FaultCode.INVALID_APP_KEY, result)
    }

    @Test
    fun invalidParameterFaultCodeReturnsCorrectEnumValue() {
        val result = FaultCode.convertFromString("INVALID_PARAMETER")

        assertEquals(FaultCode.INVALID_PARAMETER, result)
    }

    @Test
    fun processingErrorFaultCodeReturnsCorrectEnumValue() {
        val result = FaultCode.convertFromString("PROCESSING_ERROR")

        assertEquals(FaultCode.PROCESSING_ERROR, result)
    }

    @Test
    fun systemMaintenanceFaultCodeReturnsCorrectEnumValue() {
        val result = FaultCode.convertFromString("SYSTEM_MAINTENANCE")

        assertEquals(FaultCode.SYSTEM_MAINTENANCE, result)
    }

    @Test
    fun systemOverloadedFaultCodeReturnsCorrectEnumValue() {
        val result = FaultCode.convertFromString("SYSTEM_OVERLOADED")

        assertEquals(FaultCode.SYSTEM_OVERLOADED, result)
    }

    @Test
    fun nullFaultCodeReturnsNullEnumValue() {
        val result = FaultCode.convertFromString(null)

        assertNull(result)
    }

    @Test
    fun emptyFaultCodeReturnsNullEnumValue() {
        val result = FaultCode.convertFromString("")

        assertNull(result)
    }

    @Test
    fun randomFaultCodeReturnsNullEnumValue() {
        val result = FaultCode.convertFromString("random")

        assertNull(result)
    }
}