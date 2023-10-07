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

package uk.org.rivernile.edinburghbustrackerapi.bustimes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BusTime(
    @SerialName("operatorId") val operatorId: String? = null,
    @SerialName("stopId") val stopId: String? = null,
    @SerialName("stopName") val stopName: String? = null,
    @SerialName("refService") val refService: String? = null,
    @SerialName("mnemoService") val mnemoService: String? = null,
    @SerialName("nameService") val nameService: String? = null,
    @SerialName("timeDatas") val timeDatas: List<TimeData>? = null,
    @SerialName("globalDisruption") val globalDisruption: Boolean? = null,
    @SerialName("serviceDisruption") val serviceDisruption: Boolean? = null,
    @SerialName("busStopDisruption") val busStopDisruption: Boolean? = null,
    @SerialName("serviceDiversion") val serviceDiversion: Boolean? = null)
