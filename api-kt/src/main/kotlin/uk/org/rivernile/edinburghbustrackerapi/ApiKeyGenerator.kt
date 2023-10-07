/*
 * Copyright 2023 Niall Scott
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

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.toJavaInstant
import okio.ByteString.Companion.encodeUtf8
import java.text.SimpleDateFormat
import java.util.*

/**
 * This is a utility class to generate a hashed API key for use with the Edinburgh Bus Tracker API.
 *
 * An API key is provided to you when you sign up for the API. This API key cannot be used directly with the API as it
 * needs to go through a transformation by the client before it can be used. This class performs this transformation.
 *
 * Obtain an instance of this class by calling the constructor with the unhashed API key you were provided. To then
 * obtain the hashed API key to send with the API request, call the [getHashedApiKey] method. Assuming your unhashed
 * API key is valid and the [Instant] object you supply is for the current time, then your request should succeed. Pay
 * attention to any errors returned by the API.
 *
 * Longer explanation: hashed API keys must go through this transformation:
 * `md5(<unhashed API key> + <time now formatted as yyyyMMddHH>)`
 *
 *  1. Format the current time in the format `yyyyMMddHH`.
 *  2. Append it on to the end of the unhashed API key.
 *  3. MD5 hash the resulting [String].
 *
 *  After constructing an instance of this class, it may safely live for the duration of your application.
 *
 * @param unhashedKey Your unhashed API key.
 * @author Niall Scott
 */
class ApiKeyGenerator(
    private val unhashedKey: String) {

    private val dateFormatter = SimpleDateFormat("yyyyMMddHH").apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }

    /**
     * Given the unhashed API key passed to the constructor and the passed [instant] object, return a hashed API key
     * that can be used with the Edinburgh Bus Tracker API.
     *
     * See the class header documentation for a longer explanation on how this works.
     *
     * The [hashedApiKey] property is more appropriate for most use cases.
     *
     * @param instant Hashed API keys are time sensitive. Pass in an [Instant] object that represents the time you want
     * the hashed API key for. Most use cases will simply just pass in `Clock.System.now()` here. Must not be `null`.
     * @return A hashed API key, which uses the unhashed key provided to the constructor, and the [instant] passed to
     * this method.
     * @see hashedApiKey
     */
    fun getHashedApiKey(instant: Instant): String {
        return (unhashedKey + dateFormatter.format(Date.from(instant.toJavaInstant())))
            .encodeUtf8()
            .md5()
            .hex()
    }

    /**
     * A convenience immutable property to get the API key. It calls [getHashedApiKey], passing in an [Instant] object
     * that uses the current system time. That is, it obtains an [Instant] object by calling `Clock.System.now()`.
     *
     * @see getHashedApiKey
     */
    val hashedApiKey: String get() = getHashedApiKey(Clock.System.now())
}
