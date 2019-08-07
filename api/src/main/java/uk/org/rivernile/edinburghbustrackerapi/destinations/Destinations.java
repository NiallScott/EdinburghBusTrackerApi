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

package uk.org.rivernile.edinburghbustrackerapi.destinations;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Destinations {

    @SerializedName("dests")
    private List<Destination> dests;
    @SerializedName("faultcode")
    private String faultCode;
    @SerializedName("faultstring")
    private String faultString;

    public List<Destination> getDestinations() {
        return dests;
    }

    public String getFaultCode() {
        return faultCode;
    }

    public String getFaultString() {
        return faultString;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Destinations that = (Destinations) o;

        if (dests != null ? !dests.equals(that.dests) : that.dests != null) {
            return false;
        }

        if (faultCode != null ? !faultCode.equals(that.faultCode) : that.faultCode != null) {
            return false;
        }

        return faultString != null ? faultString.equals(that.faultString) : that.faultString == null;
    }

    @Override
    public int hashCode() {
        int result = dests != null ? dests.hashCode() : 0;
        result = 31 * result + (faultCode != null ? faultCode.hashCode() : 0);
        result = 31 * result + (faultString != null ? faultString.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Destinations{" +
                "dests=" + dests +
                ", faultCode='" + faultCode + '\'' +
                ", faultString='" + faultString + '\'' +
                '}';
    }
}
