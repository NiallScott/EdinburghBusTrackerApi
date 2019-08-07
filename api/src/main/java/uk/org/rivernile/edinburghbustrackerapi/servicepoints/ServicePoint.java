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

package uk.org.rivernile.edinburghbustrackerapi.servicepoints;

import com.google.gson.annotations.SerializedName;

public class ServicePoint {

    @SerializedName("chainage")
    private int chainage;
    @SerializedName("order")
    private int order;
    @SerializedName("x")
    private double x;
    @SerializedName("y")
    private double y;

    public int getChainage() {
        return chainage;
    }

    public int getOrder() {
        return order;
    }

    public double getLatitude() {
        return x;
    }

    public double getLongitude() {
        return y;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final ServicePoint that = (ServicePoint) o;

        if (chainage != that.chainage) {
            return false;
        }

        if (order != that.order) {
            return false;
        }

        if (Double.compare(that.x, x) != 0) {
            return false;
        }

        return Double.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = chainage;
        result = 31 * result + order;
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return "ServicePoint{" +
                "chainage=" + chainage +
                ", order=" + order +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
