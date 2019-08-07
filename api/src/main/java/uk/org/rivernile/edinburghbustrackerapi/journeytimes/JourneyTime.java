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

package uk.org.rivernile.edinburghbustrackerapi.journeytimes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JourneyTime {

    @SerializedName("journeyId")
    private String journeyId;
    @SerializedName("busId")
    private String busId;
    @SerializedName("operatorId")
    private String operatorId;
    @SerializedName("refService")
    private String refService;
    @SerializedName("mnemoService")
    private String mnemoService;
    @SerializedName("nameService")
    private String nameService;
    @SerializedName("refDest")
    private String refDest;
    @SerializedName("nameDest")
    private String nameDest;
    @SerializedName("journeyTimesDatas")
    private List<JourneyTimeData> journeyTimesDatas;
    @SerializedName("globalDisruption")
    private boolean globalDisruption;
    @SerializedName("serviceDisruption")
    private boolean serviceDisruption;
    @SerializedName("serviceDiversion")
    private boolean serviceDiversion;

    public String getJourneyId() {
        return journeyId;
    }

    public String getBusId() {
        return busId;
    }

    public String getOperatorId() {
        return operatorId;
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

    public String getRefDest() {
        return refDest;
    }

    public String getNameDest() {
        return nameDest;
    }

    public List<JourneyTimeData> getJourneyTimesDatas() {
        return journeyTimesDatas;
    }

    public boolean isGlobalDisruption() {
        return globalDisruption;
    }

    public boolean isServiceDisruption() {
        return serviceDisruption;
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

        final JourneyTime that = (JourneyTime) o;

        if (globalDisruption != that.globalDisruption) {
            return false;
        }

        if (serviceDisruption != that.serviceDisruption) {
            return false;
        }

        if (serviceDiversion != that.serviceDiversion) {
            return false;
        }

        if (journeyId != null ? !journeyId.equals(that.journeyId) : that.journeyId != null) {
            return false;
        }

        if (busId != null ? !busId.equals(that.busId) : that.busId != null) {
            return false;
        }

        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) {
            return false;
        }

        if (refService != null ? !refService.equals(that.refService) : that.refService != null) {
            return false;
        }

        if (mnemoService != null ? !mnemoService.equals(that.mnemoService) : that.mnemoService != null) {
            return false;
        }

        if (nameService != null ? !nameService.equals(that.nameService) : that.nameService != null) {
            return false;
        }

        if (refDest != null ? !refDest.equals(that.refDest) : that.refDest != null) {
            return false;
        }

        if (nameDest != null ? !nameDest.equals(that.nameDest) : that.nameDest != null) {
            return false;
        }

        return journeyTimesDatas != null ? journeyTimesDatas.equals(that.journeyTimesDatas)
                : that.journeyTimesDatas == null;
    }

    @Override
    public int hashCode() {
        int result = journeyId != null ? journeyId.hashCode() : 0;
        result = 31 * result + (busId != null ? busId.hashCode() : 0);
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (refService != null ? refService.hashCode() : 0);
        result = 31 * result + (mnemoService != null ? mnemoService.hashCode() : 0);
        result = 31 * result + (nameService != null ? nameService.hashCode() : 0);
        result = 31 * result + (refDest != null ? refDest.hashCode() : 0);
        result = 31 * result + (nameDest != null ? nameDest.hashCode() : 0);
        result = 31 * result + (journeyTimesDatas != null ? journeyTimesDatas.hashCode() : 0);
        result = 31 * result + (globalDisruption ? 1 : 0);
        result = 31 * result + (serviceDisruption ? 1 : 0);
        result = 31 * result + (serviceDiversion ? 1 : 0);

        return result;
    }

    @Override
    public String toString() {
        return "JourneyTime{" +
                "journeyId='" + journeyId + '\'' +
                ", busId='" + busId + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", refService='" + refService + '\'' +
                ", mnemoService='" + mnemoService + '\'' +
                ", nameService='" + nameService + '\'' +
                ", refDest='" + refDest + '\'' +
                ", nameDest='" + nameDest + '\'' +
                ", journeyTimesDatas=" + journeyTimesDatas +
                ", globalDisruption=" + globalDisruption +
                ", serviceDisruption=" + serviceDisruption +
                ", serviceDiversion=" + serviceDiversion +
                '}';
    }
}
