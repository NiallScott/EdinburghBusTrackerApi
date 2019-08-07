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

package uk.org.rivernile.edinburghbustrackerapi.diversions;

import com.google.gson.annotations.SerializedName;

public class CancelledBusStop {

    @SerializedName("stopId")
    private String stopId;
    @SerializedName("stopName")
    private String stopName;
    @SerializedName("replacedStopId")
    private String replacedStopId;
    @SerializedName("replacedStopName")
    private String replacedStopName;

    public String getStopId() {
        return stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public String getReplacedStopId() {
        return replacedStopId;
    }

    public String getReplacedStopName() {
        return replacedStopName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final CancelledBusStop that = (CancelledBusStop) o;

        if (stopId != null ? !stopId.equals(that.stopId) : that.stopId != null) {
            return false;
        }

        if (stopName != null ? !stopName.equals(that.stopName) : that.stopName != null) {
            return false;
        }

        if (replacedStopId != null ? !replacedStopId.equals(that.replacedStopId) : that.replacedStopId != null) {
            return false;
        }

        return replacedStopName != null ? replacedStopName.equals(that.replacedStopName)
                : that.replacedStopName == null;
    }

    @Override
    public int hashCode() {
        int result = stopId != null ? stopId.hashCode() : 0;
        result = 31 * result + (stopName != null ? stopName.hashCode() : 0);
        result = 31 * result + (replacedStopId != null ? replacedStopId.hashCode() : 0);
        result = 31 * result + (replacedStopName != null ? replacedStopName.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "CancelledBusStop{" +
                "stopId='" + stopId + '\'' +
                ", stopName='" + stopName + '\'' +
                ", replacedStopId='" + replacedStopId + '\'' +
                ", replacedStopName='" + replacedStopName + '\'' +
                '}';
    }
}
