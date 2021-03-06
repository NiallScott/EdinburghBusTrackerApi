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

import java.util.List;

public class ServicePoints {

    @SerializedName("ref")
    private String ref;
    @SerializedName("operatorId")
    private String operatorId;
    @SerializedName("servicePoints")
    private List<ServicePoint> servicePoints;
    @SerializedName("faultcode")
    private String faultCode;
    @SerializedName("faultstring")
    private String faultString;

    public String getRef() {
        return ref;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public List<ServicePoint> getServicePoints() {
        return servicePoints;
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

        final ServicePoints that = (ServicePoints) o;

        if (ref != null ? !ref.equals(that.ref) : that.ref != null) {
            return false;
        }

        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) {
            return false;
        }

        if (servicePoints != null ? !servicePoints.equals(that.servicePoints) : that.servicePoints != null) {
            return false;
        }

        if (faultCode != null ? !faultCode.equals(that.faultCode) : that.faultCode != null) {
            return false;
        }

        return faultString != null ? faultString.equals(that.faultString) : that.faultString == null;
    }

    @Override
    public int hashCode() {
        int result = ref != null ? ref.hashCode() : 0;
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (servicePoints != null ? servicePoints.hashCode() : 0);
        result = 31 * result + (faultCode != null ? faultCode.hashCode() : 0);
        result = 31 * result + (faultString != null ? faultString.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "ServicePoints{" +
                "ref='" + ref + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", servicePoints=" + servicePoints +
                ", faultCode='" + faultCode + '\'' +
                ", faultString='" + faultString + '\'' +
                '}';
    }
}
