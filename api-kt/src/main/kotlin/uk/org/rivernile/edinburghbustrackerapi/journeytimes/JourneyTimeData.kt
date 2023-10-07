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

package uk.org.rivernile.edinburghbustrackerapi.journeytimes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JourneyTimeData(
    @SerialName("order") val order: Int? = null,
    @SerialName("stopId") val stopId: String? = null,
    @SerialName("stopName") val stopName: String? = null,
    @SerialName("day") val day: Int? = null,
    @SerialName("time") val time: String? = null,
    @SerialName("minutes") val minutes: Int? = null,
    @SerialName("reliability") val reliability: String? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("busStopDisruption") val busStopDisruption: Boolean? = null) {

    companion object {

        const val RELIABILITY_DELAYED = 'B'
        const val RELIABILITY_DELOCATED = 'D'
        const val RELIABILITY_REAL_TIME_NO_LOW_FLOOR = 'F'
        const val RELIABILITY_REAL_TIME_LOW_FLOOR = 'H'
        const val RELIABILITY_IMMOBILISED = 'I'
        const val RELIABILITY_NEUTRALISED = 'N'
        const val RELIABILITY_RADIO_FAULT = 'R'
        const val RELIABILITY_ESTIMATED_TIME = 'T'
        const val RELIABILITY_DIVERTED = 'V'

        const val TYPE_TERMINUS_STOP = 'D'
        const val TYPE_NORMAL_STOP = 'N'
        const val TYPE_PART_ROUTE = 'P'
        const val TYPE_REFERENCE_STOP = 'R'
    }
}
