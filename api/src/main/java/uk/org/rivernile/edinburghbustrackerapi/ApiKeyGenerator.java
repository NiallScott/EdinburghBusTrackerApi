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

public class ApiKeyGenerator {

    private final String unhashedKey;
    private final SimpleDateFormat dateFormatter;

    public ApiKeyGenerator(final String unhashedKey) {
        this.unhashedKey = unhashedKey;

        dateFormatter = new SimpleDateFormat("yyyyMMddHH");
        dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

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
        } catch(NoSuchAlgorithmException e) {
            return "";
        }
    }
}
