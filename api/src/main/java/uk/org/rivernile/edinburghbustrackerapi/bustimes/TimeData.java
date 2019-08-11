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

public class TimeData {

    public static final char RELIABILITY_DELAYED = 'B';
    public static final char RELIABILITY_DELOCATED = 'D';
    public static final char RELIABILITY_REAL_TIME_NO_LOW_FLOOR = 'F';
    public static final char RELIABILITY_REAL_TIME_LOW_FLOOR = 'H';
    public static final char RELIABILITY_IMMOBILISED = 'I';
    public static final char RELIABILITY_NEUTRALISED = 'N';
    public static final char RELIABILITY_RADIO_FAULT = 'R';
    public static final char RELIABILITY_ESTIMATED_TIME = 'T';
    public static final char RELIABILITY_DIVERTED = 'V';

    public static final char TYPE_TERMINUS_STOP = 'D';
    public static final char TYPE_NORMAL_STOP = 'N';
    public static final char TYPE_PART_ROUTE = 'P';
    public static final char TYPE_REFERENCE_STOP = 'R';

    @SerializedName("refDest")
    private String refDest;
    @SerializedName("nameDest")
    private String nameDest;
    @SerializedName("day")
    private int day;
    @SerializedName("time")
    private String time;
    @SerializedName("minutes")
    private int minutes;
    @SerializedName("reliability")
    private String reliability;
    @SerializedName("type")
    private String type;
    @SerializedName("terminus")
    private String terminus;
    @SerializedName("journeyId")
    private String journeyId;
    @SerializedName("busId")
    private String busId;

    public String getRefDest() {
        return refDest;
    }

    public String getNameDest() {
        return nameDest;
    }

    public int getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public int getMinutes() {
        return minutes;
    }

    public String getReliability() {
        return reliability;
    }

    public String getType() {
        return type;
    }

    public String getTerminus() {
        return terminus;
    }

    public String getJourneyId() {
        return journeyId;
    }

    public String getBusId() {
        return busId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final TimeData timeData = (TimeData) o;

        if (refDest != null ? !refDest.equals(timeData.refDest) : timeData.refDest != null) {
            return false;
        }

        if (nameDest != null ? !nameDest.equals(timeData.nameDest) : timeData.nameDest != null) {
            return false;
        }

        if (day != timeData.day) {
            return false;
        }

        if (minutes != timeData.minutes) {
            return false;
        }

        if (time != null ? !time.equals(timeData.time) : timeData.time != null) {
            return false;
        }

        if (reliability != null ? !reliability.equals(timeData.reliability) : timeData.reliability != null) {
            return false;
        }

        if (type != null ? !type.equals(timeData.type) : timeData.type != null) {
            return false;
        }

        if (terminus != null ? !terminus.equals(timeData.terminus) : timeData.terminus != null) {
            return false;
        }

        if (journeyId != null ? !journeyId.equals(timeData.journeyId) : timeData.journeyId != null) {
            return false;
        }

        return busId != null ? busId.equals(timeData.busId) : timeData.busId == null;
    }

    @Override
    public int hashCode() {
        int result = refDest != null ? refDest.hashCode() : 0;
        result = 31 * result + (nameDest != null ? nameDest.hashCode() : 0);
        result = 31 * result + day;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + minutes;
        result = 31 * result + (reliability != null ? reliability.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (terminus != null ? terminus.hashCode() : 0);
        result = 31 * result + (journeyId != null ? journeyId.hashCode() : 0);
        result = 31 * result + (busId != null ? busId.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "TimeData{" +
                "refDest='" + refDest + '\'' +
                ", nameDest='" + nameDest + '\'' +
                ", day=" + day +
                ", time='" + time + '\'' +
                ", minutes=" + minutes +
                ", reliability='" + reliability + '\'' +
                ", type='" + type + '\'' +
                ", terminus='" + terminus + '\'' +
                ", journeyId='" + journeyId + '\'' +
                ", busId='" + busId + '\'' +
                '}';
    }
}
