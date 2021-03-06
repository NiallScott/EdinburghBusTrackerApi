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

public class BusTime {

    @SerializedName("operatorId")
    private String operatorId;
    @SerializedName("stopId")
    private String stopId;
    @SerializedName("stopName")
    private String stopName;
    @SerializedName("refService")
    private String refService;
    @SerializedName("mnemoService")
    private String mnemoService;
    @SerializedName("nameService")
    private String nameService;
    @SerializedName("timeDatas")
    private List<TimeData> timeDatas;
    @SerializedName("globalDisruption")
    private boolean globalDisruption;
    @SerializedName("serviceDisruption")
    private boolean serviceDisruption;
    @SerializedName("busStopDisruption")
    private boolean busStopDisruption;
    @SerializedName("serviceDiversion")
    private boolean serviceDiversion;

    public String getOperatorId() {
        return operatorId;
    }

    public String getStopId() {
        return stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public String getRefService() {
        return refService;
    }

    public String getMnemoService() {
        return mnemoService;
    }

    public String getNameService() {
        return nameService;
    }

    public List<TimeData> getTimeDatas() {
        return timeDatas;
    }

    public boolean isGlobalDisruption() {
        return globalDisruption;
    }

    public boolean isServiceDisruption() {
        return serviceDisruption;
    }

    public boolean isBusStopDisruption() {
        return busStopDisruption;
    }

    public boolean isServiceDiversion() {
        return serviceDiversion;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final BusTime busTime = (BusTime) o;

        if (globalDisruption != busTime.globalDisruption) {
            return false;
        }

        if (serviceDisruption != busTime.serviceDisruption) {
            return false;
        }

        if (busStopDisruption != busTime.busStopDisruption) {
            return false;
        }

        if (serviceDiversion != busTime.serviceDiversion) {
            return false;
        }

        if (operatorId != null ? !operatorId.equals(busTime.operatorId) : busTime.operatorId != null) {
            return false;
        }

        if (stopId != null ? !stopId.equals(busTime.stopId) : busTime.stopId != null) {
            return false;
        }

        if (stopName != null ? !stopName.equals(busTime.stopName) : busTime.stopName != null) {
            return false;
        }

        if (refService != null ? !refService.equals(busTime.refService) : busTime.refService != null) {
            return false;
        }

        if (mnemoService != null ? !mnemoService.equals(busTime.mnemoService) : busTime.mnemoService != null) {
            return false;
        }

        if (nameService != null ? !nameService.equals(busTime.nameService) : busTime.nameService != null) {
            return false;
        }

        return timeDatas != null ? timeDatas.equals(busTime.timeDatas) : busTime.timeDatas == null;
    }

    @Override
    public int hashCode() {
        int result = operatorId != null ? operatorId.hashCode() : 0;
        result = 31 * result + (stopId != null ? stopId.hashCode() : 0);
        result = 31 * result + (stopName != null ? stopName.hashCode() : 0);
        result = 31 * result + (refService != null ? refService.hashCode() : 0);
        result = 31 * result + (mnemoService != null ? mnemoService.hashCode() : 0);
        result = 31 * result + (nameService != null ? nameService.hashCode() : 0);
        result = 31 * result + (timeDatas != null ? timeDatas.hashCode() : 0);
        result = 31 * result + (globalDisruption ? 1 : 0);
        result = 31 * result + (serviceDisruption ? 1 : 0);
        result = 31 * result + (busStopDisruption ? 1 : 0);
        result = 31 * result + (serviceDiversion ? 1 : 0);

        return result;
    }

    @Override
    public String toString() {
        return "BusTime{" +
                "operatorId='" + operatorId + '\'' +
                ", stopId='" + stopId + '\'' +
                ", stopName='" + stopName + '\'' +
                ", refService='" + refService + '\'' +
                ", mnemoService='" + mnemoService + '\'' +
                ", nameService='" + nameService + '\'' +
                ", timeDatas=" + timeDatas +
                ", globalDisruption=" + globalDisruption +
                ", serviceDisruption=" + serviceDisruption +
                ", busStopDisruption=" + busStopDisruption +
                ", serviceDiversion=" + serviceDiversion +
                '}';
    }
}
