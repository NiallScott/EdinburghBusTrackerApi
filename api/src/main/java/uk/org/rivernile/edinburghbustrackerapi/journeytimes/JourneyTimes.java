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

import java.util.List;

public class JourneyTimes {

    private List<JourneyTime> journeyTimes;

    public List<JourneyTime> getJourneyTimes() {
        return journeyTimes;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final JourneyTimes that = (JourneyTimes) o;

        return journeyTimes != null ? journeyTimes.equals(that.journeyTimes) : that.journeyTimes == null;
    }

    @Override
    public int hashCode() {
        return journeyTimes != null ? journeyTimes.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "JourneyTimes{" +
                "journeyTimes=" + journeyTimes +
                '}';
    }
}
