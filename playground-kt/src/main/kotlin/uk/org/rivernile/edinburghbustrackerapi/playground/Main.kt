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

package uk.org.rivernile.edinburghbustrackerapi.playground

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okio.IOException
import retrofit2.Retrofit
import retrofit2.create
import uk.org.rivernile.edinburghbustrackerapi.ApiKeyGenerator
import uk.org.rivernile.edinburghbustrackerapi.EdinburghBusTrackerApi
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    args.firstOrNull()
        ?.takeIf(String::isNotBlank)
        ?.let {
            Main(it).runPlayground()
        }
        ?: throw IllegalArgumentException("The API key was not provided.")
}

class Main(
    apiKey: String) {

    private val keyGenerator = ApiKeyGenerator(apiKey)

    fun runPlayground() {
        println("Running playground (Kotlin). Hashed key = ${keyGenerator.hashedApiKey}")

        val api = createApi()

        runBlocking(Dispatchers.Default) {
            doGetTopoId(api)
            doGetServices(api)
            doGetBusTimes(api)
            doGetDisruptions(api)
        }
    }

    private fun createApi(): EdinburghBusTrackerApi {
        val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .followRedirects(false)
            .build()

        val json = Json { ignoreUnknownKeys = true }

        val retrofit = Retrofit.Builder()
            .baseUrl("http://ws.mybustracker.co.uk/")
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

        return retrofit.create<EdinburghBusTrackerApi>()
    }

    private suspend fun doGetTopoId(api: EdinburghBusTrackerApi) {
        try {
            val response = api.getTopoId(keyGenerator.hashedApiKey, null)

            if (response.isSuccessful) {
                println("doGetTopoId(): Success response.")
                println(response.body())
            } else {
                println("doGetTopoId(): Failure response.")
                println(response.errorBody())
            }
        } catch (e: IOException) {
            println("Failed to talk to server. Error = $e")
        } catch (e: SerializationException) {
            println("Failed to deserialise data from server. Error = $e")
        }
    }

    private suspend fun doGetServices(api: EdinburghBusTrackerApi) {
        try {
            val response = api.getServices(keyGenerator.hashedApiKey, null)

            if (response.isSuccessful) {
                println("doGetServices(): Success response.")
                println(response.body())
            } else {
                println("doGetServices(): Failure response.")
                println(response.errorBody())
            }
        } catch (e: IOException) {
            println("Failed to talk to server. Error = $e")
        } catch (e: SerializationException) {
            println("Failed to deserialise data from server. Error = $e")
        }
    }

    private suspend fun doGetBusTimes(api: EdinburghBusTrackerApi) {
        try {
            val response = api.getBusTimes(keyGenerator.hashedApiKey, 4, "36243252")

            if (response.isSuccessful) {
                println("doGetBusTimes(): Success response.")
                println(response.body())
            } else {
                println("doGetBusTimes(): Failure response.")
                println(response.errorBody())
            }
        } catch (e: IOException) {
            println("Failed to talk to server. Error = $e")
        } catch (e: SerializationException) {
            println("Failed to deserialise data from server. Error = $e")
        }
    }

    private suspend fun doGetDisruptions(api: EdinburghBusTrackerApi) {
        try {
            val response = api.getDisruptions(keyGenerator.hashedApiKey, null, 0)

            if (response.isSuccessful) {
                println("doGetDisruptions(): Success response.")
                println(response.body())
            } else {
                println("doGetDisruptions(): Failure response.")
                println(response.errorBody())
            }
        } catch (e: IOException) {
            println("Failed to talk to server. Error = $e")
        } catch (e: SerializationException) {
            println("Failed to deserialise data from server. Error = $e")
        }
    }
}
