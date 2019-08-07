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

package uk.org.rivernile.edinburghbustrackerapi.busstops;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusStop {

    @SerializedName("ref")
    private String ref;
    @SerializedName("operatorId")
    private String operatorId;
    @SerializedName("stopId")
    private String stopId;
    @SerializedName("name")
    private String name;
    @SerializedName("x")
    private double x;
    @SerializedName("y")
    private double y;
    @SerializedName("cap")
    private int cap;
    @SerializedName("services")
    private List<String> services;
    @SerializedName("dests")
    private List<String> dests;

    public String getRef() {
        return ref;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public String getStopId() {
        return stopId;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return x;
    }

    public double getLongitude() {
        return y;
    }

    public int getCap() {
        return cap;
    }

    public List<String> getServices() {
        return services;
    }

    public List<String> getDestinations() {
        return dests;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final BusStop busStop = (BusStop) o;

        if (Double.compare(busStop.x, x) != 0) {
            return false;
        }

        if (Double.compare(busStop.y, y) != 0) {
            return false;
        }

        if (cap != busStop.cap) {
            return false;
        }

        if (ref != null ? !ref.equals(busStop.ref) : busStop.ref != null) {
            return false;
        }

        if (operatorId != null ? !operatorId.equals(busStop.operatorId) : busStop.operatorId != null) {
            return false;
        }

        if (stopId != null ? !stopId.equals(busStop.stopId) : busStop.stopId != null) {
            return false;
        }

        if (name != null ? !name.equals(busStop.name) : busStop.name != null) {
            return false;
        }

        if (services != null ? !services.equals(busStop.services) : busStop.services != null) {
            return false;
        }

        return dests != null ? dests.equals(busStop.dests) : busStop.dests == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ref != null ? ref.hashCode() : 0;
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (stopId != null ? stopId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cap;
        result = 31 * result + (services != null ? services.hashCode() : 0);
        result = 31 * result + (dests != null ? dests.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "BusStop{" +
                "ref='" + ref + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", stopId='" + stopId + '\'' +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", cap=" + cap +
                ", services=" + services +
                ", dests=" + dests +
                '}';
    }
}
