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

import java.util.Date;
import java.util.List;

public class Diversion {

    @SerializedName("ref")
    private String ref;
    @SerializedName("diversionId")
    private String diversionId;
    @SerializedName("operatorId")
    private String operatorId;
    @SerializedName("refService")
    private String refService;
    @SerializedName("startStopId")
    private String startStopId;
    @SerializedName("startStopName")
    private String startStopName;
    @SerializedName("startDate")
    private Date startDate;
    @SerializedName("endStopId")
    private String endStopId;
    @SerializedName("endStopName")
    private String endStopName;
    @SerializedName("endDate")
    private Date endDate;
    @SerializedName("length")
    private int length;
    @SerializedName("timeShift")
    private int timeShift;
    @SerializedName("cancelledBusStops")
    private List<CancelledBusStop> cancelledBusStops;

    public String getRef() {
        return ref;
    }

    public String getDiversionId() {
        return diversionId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public String getRefService() {
        return refService;
    }

    public String getStartStopId() {
        return startStopId;
    }

    public String getStartStopName() {
        return startStopName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getEndStopId() {
        return endStopId;
    }

    public String getEndStopName() {
        return endStopName;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getLength() {
        return length;
    }

    public int getTimeShift() {
        return timeShift;
    }

    public List<CancelledBusStop> getCancelledBusStops() {
        return cancelledBusStops;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Diversion diversion = (Diversion) o;

        if (length != diversion.length) {
            return false;
        }

        if (timeShift != diversion.timeShift) {
            return false;
        }

        if (ref != null ? !ref.equals(diversion.ref) : diversion.ref != null) {
            return false;
        }

        if (diversionId != null ? !diversionId.equals(diversion.diversionId) : diversion.diversionId != null) {
            return false;
        }

        if (operatorId != null ? !operatorId.equals(diversion.operatorId) : diversion.operatorId != null) {
            return false;
        }

        if (refService != null ? !refService.equals(diversion.refService) : diversion.refService != null) {
            return false;
        }

        if (startStopId != null ? !startStopId.equals(diversion.startStopId) : diversion.startStopId != null) {
            return false;
        }

        if (startStopName != null ? !startStopName.equals(diversion.startStopName) : diversion.startStopName != null) {
            return false;
        }

        if (startDate != null ? !startDate.equals(diversion.startDate) : diversion.startDate != null) {
            return false;
        }

        if (endStopId != null ? !endStopId.equals(diversion.endStopId) : diversion.endStopId != null) {
            return false;
        }

        if (endStopName != null ? !endStopName.equals(diversion.endStopName) : diversion.endStopName != null) {
            return false;
        }

        if (endDate != null ? !endDate.equals(diversion.endDate) : diversion.endDate != null) {
            return false;
        }

        return cancelledBusStops != null ? cancelledBusStops.equals(diversion.cancelledBusStops)
                : diversion.cancelledBusStops == null;
    }

    @Override
    public int hashCode() {
        int result = ref != null ? ref.hashCode() : 0;
        result = 31 * result + (diversionId != null ? diversionId.hashCode() : 0);
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (refService != null ? refService.hashCode() : 0);
        result = 31 * result + (startStopId != null ? startStopId.hashCode() : 0);
        result = 31 * result + (startStopName != null ? startStopName.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endStopId != null ? endStopId.hashCode() : 0);
        result = 31 * result + (endStopName != null ? endStopName.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + length;
        result = 31 * result + timeShift;
        result = 31 * result + (cancelledBusStops != null ? cancelledBusStops.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Diversion{" +
                "ref='" + ref + '\'' +
                ", diversionId='" + diversionId + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", refService='" + refService + '\'' +
                ", startStopId='" + startStopId + '\'' +
                ", startStopName='" + startStopName + '\'' +
                ", startDate=" + startDate +
                ", endStopId='" + endStopId + '\'' +
                ", endStopName='" + endStopName + '\'' +
                ", endDate=" + endDate +
                ", length=" + length +
                ", timeShift=" + timeShift +
                ", cancelledBusStops=" + cancelledBusStops +
                '}';
    }
}
