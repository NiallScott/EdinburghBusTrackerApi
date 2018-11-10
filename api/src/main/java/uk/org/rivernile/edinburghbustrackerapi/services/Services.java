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

package uk.org.rivernile.edinburghbustrackerapi.services;

import java.util.List;

public class Services {

    private List<Service> services;

    public List<Service> getServices() {
        return services;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Services services1 = (Services) o;

        return services != null ? services.equals(services1.services) : services1.services == null;
    }

    @Override
    public int hashCode() {
        return services != null ? services.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Services{" +
                "services=" + services +
                '}';
    }
}
