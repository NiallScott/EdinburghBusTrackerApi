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

/**
 * This is an enumeration of all the documented errors that may be returned from the Edinburgh Bus Tracker API.
 *
 * The root model objects returned to you by the methods in [EdinburghBusTrackerApi] will contain a `faultCode`
 * property. This will be returned as a [String]. To convert this in to a value of this enumeration, then use the
 * [convertFromString] method.
 *
 * @author Niall Scott
 */
enum class FaultCode {

    /**
     * An invalid API key has been supplied to the API.
     *
     * Tip: remember to use the [ApiKeyGenerator] class supplied by this library. If you have a valid API key, and you
     * use this class correctly, it will generate you a valid API key.
     *
     * API keys are time sensitive, so make sure you pass the correct time in to [ApiKeyGenerator.getHashedApiKey].
     *
     * @see ApiKeyGenerator
     */
    INVALID_APP_KEY,
    /**
     * An invalid parameter has been supplied to the API. Consult the `faultMessage` property in the root object
     * returned from the API to see more detail about this error.
     */
    INVALID_PARAMETER,
    /**
     * There was an error processing the request. Consult the `faultMessage` property in the root object returned from
     * the API to see more detail about this error.
     */
    PROCESSING_ERROR,
    /** The API is down for maintenance. An immediate retry is also likely to fail. Retry later. */
    SYSTEM_MAINTENANCE,
    /**
     * The API is currently overloaded. Immediately retrying will likely add to the problems. The best strategy to apply
     * here is an exponential back-off.
     */
    SYSTEM_OVERLOADED;

    companion object {

        /**
         * Given a fault string, convert it in to its [FaultCode] representation.
         *
         * @param faultString The fault string supplied by the API.
         * @return The correct [FaultCode] for the fault string. This will return `null` if fault code is `null`, empty
         * or not recognised.
         */
        @JvmStatic
        fun convertFromString(faultString: String?): FaultCode? {
            return faultString?.ifBlank { null }?.let {
                values().firstOrNull { value ->
                    value.name == it
                }
            }
        }
    }
}