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

public class JourneyTimeData {

    private int order;
    private String stopId;
    private String stopName;
    private int day;
    private String time;
    private int minutes;
    private String reliability;
    private String type;
    private boolean busStopDisruption;

    public int getOrder() {
        return order;
    }

    public String getStopId() {
        return stopId;
    }

    public String getStopName() {
        return stopName;
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

    public boolean isBusStopDisruption() {
        return busStopDisruption;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final JourneyTimeData that = (JourneyTimeData) o;

        if (order != that.order) {
            return false;
        }

        if (day != that.day) {
            return false;
        }

        if (minutes != that.minutes) {
            return false;
        }

        if (busStopDisruption != that.busStopDisruption) {
            return false;
        }

        if (stopId != null ? !stopId.equals(that.stopId) : that.stopId != null) {
            return false;
        }

        if (stopName != null ? !stopName.equals(that.stopName) : that.stopName != null) {
            return false;
        }

        if (time != null ? !time.equals(that.time) : that.time != null) {
            return false;
        }

        if (reliability != null ? !reliability.equals(that.reliability) : that.reliability != null) {
            return false;
        }

        return type != null ? type.equals(that.type) : that.type == null;
    }

    @Override
    public int hashCode() {
        int result = order;
        result = 31 * result + (stopId != null ? stopId.hashCode() : 0);
        result = 31 * result + (stopName != null ? stopName.hashCode() : 0);
        result = 31 * result + day;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + minutes;
        result = 31 * result + (reliability != null ? reliability.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (busStopDisruption ? 1 : 0);

        return result;
    }

    @Override
    public String toString() {
        return "JourneyTimeData{" +
                "order=" + order +
                ", stopId='" + stopId + '\'' +
                ", stopName='" + stopName + '\'' +
                ", day=" + day +
                ", time='" + time + '\'' +
                ", minutes=" + minutes +
                ", reliability='" + reliability + '\'' +
                ", type='" + type + '\'' +
                ", busStopDisruption=" + busStopDisruption +
                '}';
    }
}
