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

package uk.org.rivernile.edinburghbustrackerapi.diversionpoints;

import java.util.List;

public class DiversionPoints {

    private String diversionId;
    private String operatorId;
    private List<ServicePoint> diversionPoints;

    public String getDiversionId() {
        return diversionId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public List<ServicePoint> getDiversionPoints() {
        return diversionPoints;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final DiversionPoints that = (DiversionPoints) o;

        if (diversionId != null ? !diversionId.equals(that.diversionId) : that.diversionId != null) {
            return false;
        }

        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) {
            return false;
        }

        return diversionPoints != null ? diversionPoints.equals(that.diversionPoints) : that.diversionPoints == null;
    }

    @Override
    public int hashCode() {
        int result = diversionId != null ? diversionId.hashCode() : 0;
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (diversionPoints != null ? diversionPoints.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "DiversionPoints{" +
                "diversionId='" + diversionId + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", diversionPoints=" + diversionPoints +
                '}';
    }
}
