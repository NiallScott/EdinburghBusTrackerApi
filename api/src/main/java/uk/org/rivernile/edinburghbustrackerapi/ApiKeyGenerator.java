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

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * This is a utility class to generate a hashed API key for use with the Edinburgh Bus Tracker API.
 *
 * <p>
 *     An API key is provided to you when you sign up for the API. This API key cannot be used directly with the API as
 *     it needs to go through a transformation by the client before it can be used. This class performs this
 *     transformation.
 * </p>
 *
 * <p>
 *     Obtain an instance of this class by calling the constructor with the unhashed API key you were provided. To then
 *     obtain the hashed API key to send with the API request, call the {@link #getHashedApiKey(Date)} method. Assuming
 *     your unhashed API key is valid and the {@link Date} object you supply is for the current time, then your request
 *     should succeed. Pay attention to any errors returned by the API.
 * </p>
 *
 * <p>
 *     Longer explanation: hashed API keys must go through this transformation:
 *     {@code md5(<unhashed API key> + <time now formatted as yyyyMMddHH>)}
 * </p>
 *
 * <ol>
 *     <li>Format the current time in the format {@code yyyyMMddHH}.</li>
 *     <li>Append it on to the end of the unhashed API key</li>
 *     <li>MD5 hash the resulting {@link String}.</li>
 * </ol>
 *
 * @author Niall Scott
 */
public class ApiKeyGenerator {

    private final String unhashedKey;
    private final SimpleDateFormat dateFormatter;

    /**
     * Create a new instance of this class. This instance may safely live for the duration of your application.
     *
     * @param unhashedKey Your unhashed API key.
     */
    public ApiKeyGenerator(final String unhashedKey) {
        this.unhashedKey = unhashedKey;

        dateFormatter = new SimpleDateFormat("yyyyMMddHH");
        dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    /**
     * Given the unhashed API key passed to the constructor and the passed {@code time} object, return a hashed API key
     * that can be used with the Edinburgh Bus Tracker API.
     *
     * <p>
     *     See the class header documentation for a longer explanation on how this works.
     * </p>
     *
     * @param time Hashed API keys are time sensitive. Pass in a {@link Date} object that represents the time you want
     * the hashed API key for. Most use cases will simply just pass in {@code new Date()} here. Must not be
     * {@code null}.
     * @return A hashed API key, which uses the unhashed key provided to the constructor, and the {@code time} passed to
     * this method. An empty {@link String} will be returned if there was a problem generating the key.
     */
    public String getHashedApiKey(final Date time) {
        final String combinedKey = unhashedKey + dateFormatter.format(time);

        try {
            final MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(combinedKey.getBytes(), 0, combinedKey.length());
            String hashedKey = new BigInteger(1, m.digest()).toString(16);

            while (hashedKey.length() < 32) {
                hashedKey = "0" + hashedKey;
            }

            return hashedKey;
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    /**
     * A convenience method to get the API key. It calls {@link #getHashedApiKey(Date)}, passing in a {@link Date}
     * object that uses the current system time. That is, it obtains a {@link Date} object by calling
     * {@link Date#Date()}.
     *
     * @return See {@link #getHashedApiKey(Date)}.
     * @see #getHashedApiKey(Date)
     */
    public String getHashedApiKey() {
        return getHashedApiKey(new Date());
    }
}
