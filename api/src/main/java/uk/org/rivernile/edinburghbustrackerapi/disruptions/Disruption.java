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

package uk.org.rivernile.edinburghbustrackerapi.disruptions;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Disruption {

    @SerializedName("id")
    private String id;
    @SerializedName("operatorId")
    private String operatorId;
    @SerializedName("level")
    private int level;
    @SerializedName("type")
    private int type;
    @SerializedName("targets")
    private List<String> targets;
    @SerializedName("validUntil")
    private Date validUntil;
    @SerializedName("message")
    private String message;

    public String getId() {
        return id;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public int getLevel() {
        return level;
    }

    public int getType() {
        return type;
    }

    public List<String> getTargets() {
        return targets;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Disruption that = (Disruption) o;

        if (level != that.level) {
            return false;
        }

        if (type != that.type) {
            return false;
        }

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }

        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) {
            return false;
        }

        if (targets != null ? !targets.equals(that.targets) : that.targets != null) {
            return false;
        }

        if (validUntil != null ? !validUntil.equals(that.validUntil) : that.validUntil != null) {
            return false;
        }

        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + level;
        result = 31 * result + type;
        result = 31 * result + (targets != null ? targets.hashCode() : 0);
        result = 31 * result + (validUntil != null ? validUntil.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Disruption{" +
                "id='" + id + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", level=" + level +
                ", type=" + type +
                ", targets=" + targets +
                ", validUntil=" + validUntil +
                ", message='" + message + '\'' +
                '}';
    }
}
