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

package uk.org.rivernile.edinburghbustrackerapi.topoid;

import com.google.gson.annotations.SerializedName;

public class TopoId {

    @SerializedName("topoId")
    private String topoId;
    @SerializedName("operatorId")
    private String operatorId;
    @SerializedName("faultcode")
    private String faultCode;
    @SerializedName("faultstring")
    private String faultString;

    public String getTopoId() {
        return topoId;
    }

    public String getOperatorId() {
        return operatorId;
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

        final TopoId topoId1 = (TopoId) o;

        if (topoId != null ? !topoId.equals(topoId1.topoId) : topoId1.topoId != null) {
            return false;
        }

        if (operatorId != null ? !operatorId.equals(topoId1.operatorId) : topoId1.operatorId != null) {
            return false;
        }

        if (faultCode != null ? !faultCode.equals(topoId1.faultCode) : topoId1.faultCode != null) {
            return false;
        }

        return faultString != null ? faultString.equals(topoId1.faultString) : topoId1.faultString == null;
    }

    @Override
    public int hashCode() {
        int result = topoId != null ? topoId.hashCode() : 0;
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (faultCode != null ? faultCode.hashCode() : 0);
        result = 31 * result + (faultString != null ? faultString.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "TopoId{" +
                "topoId='" + topoId + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", faultCode='" + faultCode + '\'' +
                ", faultString='" + faultString + '\'' +
                '}';
    }
}
