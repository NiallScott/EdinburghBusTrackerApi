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

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Diversion(
    @SerialName("ref") val ref: String? = null,
    @SerialName("diversionId") val diversionId: String? = null,
    @SerialName("operatorId") val operatorId: String? = null,
    @SerialName("refService") val refService: String? = null,
    @SerialName("startStopId") val startStopId: String? = null,
    @SerialName("startStopName") val startStopName: String? = null,
    @SerialName("startDate") val startDate: Instant? = null,
    @SerialName("endStopId") val endStopId: String? = null,
    @SerialName("endStopName") val endStopName: String? = null,
    @SerialName("endDate") val endDate: Instant? = null,
    @SerialName("length") val length: Int? = null,
    @SerialName("timeShift") val timeShift: Int? = null,
    @SerialName("cancelldBusStops") val cancelledBusStops: List<CancelledBusStop>? = null)
