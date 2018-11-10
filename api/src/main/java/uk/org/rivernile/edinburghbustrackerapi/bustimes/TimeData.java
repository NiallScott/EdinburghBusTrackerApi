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

public class TimeData {

    private int day;
    private String time;
    private int minutes;
    private String reliability;
    private String type;
    private String terminus;
    private String journeyId;
    private String busId;

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
        int result = day;
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
                "day=" + day +
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
