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

package uk.org.rivernile.edinburghbustrackerapi.disruptions

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Disruption(
    @SerialName("id") val id: String? = null,
    @SerialName("operatorId") val operatorId: String? = null,
    @SerialName("level") val level: Int? = null,
    @SerialName("type") val type: Int? = null,
    @SerialName("targets") val targets: List<String>? = null,
    @SerialName("validUntil") val validUntil: Instant? = null,
    @SerialName("message") val message: String? = null) {

    companion object {

        const val LEVEL_INFORMATIVE = 1
        const val LEVEL_MINOR = 2
        const val LEVEL_MAJOR = 3

        const val TYPE_NETWORK = 1
        const val TYPE_SERVICE = 2
        const val TYPE_BUS_STOP = 3
    }
}
