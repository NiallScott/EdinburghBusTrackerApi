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

package uk.org.rivernile.edinburghbustrackerapi.bustimes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusTimes {

    private List<BusTime> busTimes;
    @SerializedName("faultcode")
    private String faultCode;
    @SerializedName("faultstring")
    private String faultString;

    public List<BusTime> getBusTimes() {
        return busTimes;
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

        final BusTimes busTimes1 = (BusTimes) o;

        if (busTimes != null ? !busTimes.equals(busTimes1.busTimes) : busTimes1.busTimes != null) {
            return false;
        }

        if (faultCode != null ? !faultCode.equals(busTimes1.faultCode) : busTimes1.faultCode != null) {
            return false;
        }

        return faultString != null ? faultString.equals(busTimes1.faultString) : busTimes1.faultString == null;
    }

    @Override
    public int hashCode() {
        int result = busTimes != null ? busTimes.hashCode() : 0;
        result = 31 * result + (faultCode != null ? faultCode.hashCode() : 0);
        result = 31 * result + (faultString != null ? faultString.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "BusTimes{" +
                "busTimes=" + busTimes +
                ", faultCode='" + faultCode + '\'' +
                ", faultString='" + faultString + '\'' +
                '}';
    }
}
