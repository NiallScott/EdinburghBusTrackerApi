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

public class Destination {

    public static final char DIRECTION_INBOUND = 'A';
    public static final char DIRECTION_OUTBOUND = 'R';

    @SerializedName("ref")
    private String ref;
    @SerializedName("operatorId")
    private String operatorId;
    @SerializedName("name")
    private String name;
    @SerializedName("direction")
    private String direction;
    @SerializedName("service")
    private String service;

    public String getRef() {
        return ref;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public String getName() {
        return name;
    }

    public String getDirection() {
        return direction;
    }

    public String getService() {
        return service;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Destination that = (Destination) o;

        if (ref != null ? !ref.equals(that.ref) : that.ref != null) {
            return false;
        }

        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) {
            return false;
        }

        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }

        if (direction != null ? !direction.equals(that.direction) : that.direction != null) {
            return false;
        }

        return service != null ? service.equals(that.service) : that.service == null;
    }

    @Override
    public int hashCode() {
        int result = ref != null ? ref.hashCode() : 0;
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (service != null ? service.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "ref='" + ref + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", name='" + name + '\'' +
                ", direction='" + direction + '\'' +
                ", service='" + service + '\'' +
                '}';
    }
}
