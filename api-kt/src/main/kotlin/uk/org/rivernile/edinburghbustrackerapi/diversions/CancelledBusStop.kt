/*
 * Copyright 2023 Niall Scott
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

package uk.org.rivernile.edinburghbustrackerapi.diversions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CancelledBusStop(
    @SerialName("stopId") val stopId: String? = null,
    @SerialName("stopName") val stopName: String? = null,
    @SerialName("replacedStopId") val replacedStopId: String? = null,
    @SerialName("replacedStopName") val replacedStopName: String? = null)
