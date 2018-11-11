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

import java.util.Date;

/**
 * This is an enumeration of all the documented errors that may be returned from the Edinburgh Bus Tracker API.
 *
 * <p>
 *     The root model objects returned to you in by the methods in {@link EdinburghBusTrackerApi} will contain a
 *     {@code getFaultCode()} method. This will be returned as a {@link String}. To convert this in to a value of this
 *     enumeration, then use the {@link #convertFromString(String)} method.
 * </p>
 *
 * @author Niall Scott
 */
public enum FaultCode {

    /**
     * An invalid API key has been supplied to the API.
     *
     * <p>
     *     Tip: remember to use the {@link ApiKeyGenerator} class supplied by this library. If you have a valid API key
     *     and you use this class correctly, it will generate you a valid API key.
     * </p>
     *
     * <p>
     *     API keys are time sensitive, so make sure you pass the correct time in to
     *     {@link ApiKeyGenerator#getHashedApiKey(Date)}.
     * </p>
     *
     * @see ApiKeyGenerator
     */
    INVALID_APP_KEY,
    /**
     * An invalid parameter has been supplied to the API. Consult the {@code getFaultMessage()} method in the root
     * object returned from the API to see more detail about this error.
     */
    INVALID_PARAMETER,
    /**
     * There was an error processing the request. Consult the {@code getFaultMessage()} method in the root object
     * returned from the API to see more detail about this error.
     */
    PROCESSING_ERROR,
    /** The API is down for maintenance. An immediate retry is also likely to fail. Retry later. */
    SYSTEM_MAINTENANCE,
    /**
     * The API is currently overloaded. Immediately retrying will likely add to the problems. The best strategy to apply
     * here is an exponential back-off.
     */
    SYSTEM_OVERLOADED;

    /**
     * Given a non-{@code null}, non empty fault string, convert it in to its {@link FaultCode} representation.
     *
     * @param faultString The fault string supplied by the API.
     * @return The correct {@link FaultCode} for the fault string. This will return {@code null} if fault code is
     * {@code null}, empty or not recognised.
     */
    public static FaultCode convertFromString(final String faultString) {
        if (INVALID_APP_KEY.name().equals(faultString)) {
            return INVALID_APP_KEY;
        } else if (INVALID_PARAMETER.name().equals(faultString)) {
            return INVALID_PARAMETER;
        } else if (PROCESSING_ERROR.name().equals(faultString)) {
            return PROCESSING_ERROR;
        } else if (SYSTEM_MAINTENANCE.name().equals(faultString)) {
            return SYSTEM_MAINTENANCE;
        } else if (SYSTEM_OVERLOADED.name().equals(faultString)) {
            return SYSTEM_OVERLOADED;
        } else {
            return null;
        }
    }
}
