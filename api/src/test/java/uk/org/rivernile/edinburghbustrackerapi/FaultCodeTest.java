/*
 * Copyright 2018 Niall Scott
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

package uk.org.rivernile.edinburghbustrackerapi;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class FaultCodeTest {

    @Test
    public void invalidAppKeyFaultCodeReturnsCorrectEnumValue() {
        final FaultCode result = FaultCode.convertFromString("INVALID_APP_KEY");

        assertSame(FaultCode.INVALID_APP_KEY, result);
    }

    @Test
    public void invalidParameterFaultCodeReturnsCorrectEnumValue() {
        final FaultCode result = FaultCode.convertFromString("INVALID_PARAMETER");

        assertSame(FaultCode.INVALID_PARAMETER, result);
    }

    @Test
    public void processingErrorFaultCodeReturnsCorrectEnumValue() {
        final FaultCode result = FaultCode.convertFromString("PROCESSING_ERROR");

        assertSame(FaultCode.PROCESSING_ERROR, result);
    }

    @Test
    public void systemMaintenanceFaultCodeReturnsCorrectEnumValue() {
        final FaultCode result = FaultCode.convertFromString("SYSTEM_MAINTENANCE");

        assertSame(FaultCode.SYSTEM_MAINTENANCE, result);
    }

    @Test
    public void systemOverloadedFaultCodeReturnsCorrectEnumValue() {
        final FaultCode result = FaultCode.convertFromString("SYSTEM_OVERLOADED");

        assertSame(FaultCode.SYSTEM_OVERLOADED, result);
    }

    @Test
    public void nullFaultCodeReturnsNullEnumValue() {
        final FaultCode result = FaultCode.convertFromString(null);

        assertNull(result);
    }

    @Test
    public void emptyFaultCodeReturnsNullEnumValue() {
        final FaultCode result = FaultCode.convertFromString("");

        assertNull(result);
    }

    @Test
    public void randomFaultCodeReturnsNullEnumValue() {
        final FaultCode result = FaultCode.convertFromString("random");

        assertNull(result);
    }
}