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

package uk.org.rivernile.edinburghbustrackerapi.services;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Service {

    @SerializedName("ref")
    private String ref;
    @SerializedName("operatorId")
    private String operatorId;
    @SerializedName("mnemo")
    private String mnemo;
    @SerializedName("name")
    private String name;
    @SerializedName("dests")
    private List<String> dests;

    public String getRef() {
        return ref;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public String getMnemo() {
        return mnemo;
    }

    public String getName() {
        return name;
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

        final Service that = (Service) o;

        if (ref != null ? !ref.equals(that.ref) : that.ref != null) {
            return false;
        }

        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) {
            return false;
        }

        if (mnemo != null ? !mnemo.equals(that.mnemo) : that.mnemo != null) {
            return false;
        }

        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }

        return dests != null ? dests.equals(that.dests) : that.dests == null;
    }

    @Override
    public int hashCode() {
        int result = ref != null ? ref.hashCode() : 0;
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (mnemo != null ? mnemo.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dests != null ? dests.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Service{" +
                "ref='" + ref + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", mnemo='" + mnemo + '\'' +
                ", name='" + name + '\'' +
                ", dests=" + dests +
                '}';
    }
}
