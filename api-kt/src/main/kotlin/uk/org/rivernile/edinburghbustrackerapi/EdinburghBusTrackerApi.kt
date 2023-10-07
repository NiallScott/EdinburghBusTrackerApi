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

package uk.org.rivernile.edinburghbustrackerapi

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uk.org.rivernile.edinburghbustrackerapi.busstops.BusStops
import uk.org.rivernile.edinburghbustrackerapi.bustimes.BusTimes
import uk.org.rivernile.edinburghbustrackerapi.destinations.Destinations
import uk.org.rivernile.edinburghbustrackerapi.disruptions.Disruptions
import uk.org.rivernile.edinburghbustrackerapi.diversionpoints.DiversionPoints
import uk.org.rivernile.edinburghbustrackerapi.diversions.Diversions
import uk.org.rivernile.edinburghbustrackerapi.journeytimes.JourneyTimes
import uk.org.rivernile.edinburghbustrackerapi.servicepoints.ServicePoints
import uk.org.rivernile.edinburghbustrackerapi.services.Services
import uk.org.rivernile.edinburghbustrackerapi.topoid.TopoId

/**
 * This interface defines methods to interact with the Edinburgh Bus Tracker API. It's intended to be used by Retrofit 2
 * to create a concrete implementation at runtime.
 *
 * Assuming you have created a [retrofit2.Retrofit] instance, then to obtain a concrete instance of this class simply
 * call `retrofit.create<EdinburghBusTrackerApi>()`.
 *
 * All the methods have a `hashedApiKey` parameter. Use the [ApiKeyGenerator] class to obtain a hashed API key and pass
 * the resulting key in to the method you wish to use.
 *
 * Example
 * -------
 * Firstly, set up Okhttp and Retrofit;
 *
 * ```
 * val client = OkHttpClient.Builder()
 *     // Any other Okhttp customisations you wish to make should go here.
 *     .build()
 *
 *     // TODO: finish Javadoc
 *
 * val retrofit = Retrofit.Builder()
 *     .baseUrl("http://ws.mybustracker.co.uk/")
 *     .client(client)
 *     .addConverterFactory
 * ```
 *
 * @author Niall Scott
 * @see ApiKeyGenerator
 */
interface EdinburghBusTrackerApi {

    companion object {

        /**
         * Integer constant for [.getDisruptions] to specify that all disruptions should be
         * returned.
         */
        const val DISRUPTION_TYPE_ALL = 0
        /**
         * Integer constant for [.getDisruptions] to specify that only network disruptions
         * should be returned.
         */
        const val DISRUPTION_TYPE_NETWORK = 1
        /**
         * Integer constant for [.getDisruptions] to specify that only service disruptions
         * should be returned.
         */
        const val DISRUPTION_TYPE_SERVICE = 2
        /**
         * Integer constant for [.getDisruptions] to specify that only bus stop disruptions
         * should be returned.
         */
        const val DISRUPTION_TYPE_BUS_STOP = 3
    }

    /**
     * Get the current topology ID.
     *
     * @param hashedApiKey The hashed API key. See [ApiKeyGenerator].
     * @param operatorId An optional operator ID. Pass `null` if this should not be used.
     * @return A Retrofit [Response] object for this API request.
     */
    @GET("?module=json&function=getTopoId")
    suspend fun getTopoId(
            @Query("key") hashedApiKey: String,
            @Query("operatorId") operatorId: String?): Response<TopoId>

    /**
     * Get details of all services known by the Edinburgh Bus Tracker API.
     *
     * @param hashedApiKey The hashed API key. See [ApiKeyGenerator].
     * @param operatorId An optional operator ID to filter by. Pass `null` if the filter should not apply.
     * @return A Retrofit [Response] object for this API request.
     */
    @GET("?module=json&function=getServices")
    suspend fun getServices(
            @Query("key") hashedApiKey: String,
            @Query("operatorId") operatorId: String?): Response<Services>

    /**
     * Get the service route lines for a given [serviceReference].
     *
     * @param hashedApiKey The hashed API key. See [ApiKeyGenerator].
     * @param operatorId An optional operator ID to filter by. Pass `null` if the filter should not apply. This is
     * probably useless here anyway.
     * @param serviceReference The service to get route lines for.
     * @return A Retrofit [Response] object for this API request.
     */
    @GET("?module=json&function=getServicePoints")
    suspend fun getServicePoints(
            @Query("key") hashedApiKey: String,
            @Query("operatorId") operatorId: String?,
            @Query("ref") serviceReference: String?): Response<ServicePoints>

    /**
     * Get details of all destinations known by the Edinburgh Bus Tracker API.
     *
     * @param hashedApiKey The hashed API key. See [ApiKeyGenerator].
     * @param operatorId An optional operator ID to filter by. Pass `null` if the filter should not apply.
     * @return A Retrofit [Response] object for this API request.
     */
    @GET("?module=json&function=getDests")
    suspend fun getDestinations(
            @Query("key") hashedApiKey: String,
            @Query("operatorId") operatorId: String?): Response<Destinations>

    /**
     * Get details of all bus stops known by the Edinburgh Bus Tracker API.
     *
     * @param hashedApiKey The hashed API key. See [ApiKeyGenerator].
     * @param operatorId An optional operator ID to filter by. Pass `null` if the filter should not apply.
     * @return A Retrofit [Response] object for this API request.
     */
    @GET("?module=json&function=getBusStops")
    suspend fun getBusStops(
            @Query("key") hashedApiKey: String,
            @Query("operatorId") operatorId: String?): Response<BusStops>

    /**
     * Get details of disruptions.
     *
     * @param hashedApiKey The hashed API key. See [ApiKeyGenerator].
     * @param operatorId An optional operator ID to filter by. Pass `null` if the filter should not apply.
     * @param type The type of disruption to get. `0` = all disruptions (default - set `null` to use
     * default); `1` = network disruption; `2` = service disruption; `3` = bus stop disruption.
     * @return A Retrofit [Response] object for this API request.
     */
    @GET("?module=json&function=getDisruptions")
    suspend fun getDisruptions(
            @Query("key") hashedApiKey: String,
            @Query("operatorId") operatorId: String?,
            @Query("type") type: Int?): Response<Disruptions>

    /**
     * Get details of diversions.
     *
     * @param hashedApiKey The hashed API key. See [ApiKeyGenerator].
     * @param operatorId An optional operator ID to filter by. Pass `null` if the filter should not apply.
     * @param serviceReference The service reference. Set as `null` to use the default option of all services.
     * @param day Day offset, between `0` and `3`. Set as `null` to use the default offset of `0`.
     * @return A Retrofit [Response] object for this API request.
     */
    @GET("?module=json&function=getDiversions")
    suspend fun getDiversions(
            @Query("key") hashedApiKey: String,
            @Query("operatorId") operatorId: String?,
            @Query("refService") serviceReference: String?,
            @Query("day") day: Int?): Response<Diversions>

    /**
     * Get the diversions points for a given [diversionId].
     *
     * @param hashedApiKey The hashed API key. See [ApiKeyGenerator].
     * @param operatorId An optional operator ID to filter by. Pass `null` if the filter should not apply.
     * @param diversionId The ID of the diversion to get points for.
     * @return A Retrofit [Call] object for this API request.
     */
    @GET("?module=json&function=getDiversionPoints")
    suspend fun getDiversionPoints(
            @Query("key") hashedApiKey: String,
            @Query("operatorId") operatorId: String?,
            @Query("diversionId") diversionId: String?): Response<DiversionPoints>

    /**
     * Get bus times for a given [stopId]. This is a simpler version of the call, mostly using default values. The
     * more enhanced version of this call can be found at [getBusTimes].
     *
     * @param hashedApiKey The hashed API key. See [ApiKeyGenerator].
     * @param numberOfDepartures The number of departures per service to return, between `1` and `10`. Set as `null` to
     * use the default value of `2`.
     * @param stopId The identifier of the stop.
     * @return A Retrofit [Response] object for this API request.
     */
    @GET("?module=json&function=getBusTimes")
    suspend fun getBusTimes(
            @Query("key") hashedApiKey: String,
            @Query("nb") numberOfDepartures: Int?,
            @Query("stopId") stopId: String): Response<BusTimes>

    /**
     * Get bus times for up to 5 stops. This is a simpler version of the call, mostly using default values. The more
     * enhanced version of this call can be found at [getBusTimes].
     *
     * @param hashedApiKey The hashed API key. See [ApiKeyGenerator].
     * @param numberOfDepartures The number of departures per service to return, between `1` and `10`. Set as `null` to
     * use the default value of `2`.
     * @param stopId1 The identifier of the 1st stop.
     * @param stopId2 The identifier of the 2nd stop. Set as `null` if this should not be used.
     * @param stopId3 The identifier of the 3rd stop. Set as `null` if this should not be used.
     * @param stopId4 The identifier of the 4th stop. Set as `null` if this should not be used.
     * @param stopId5 The identifier of the 5th stop. Set as `null` if this should not be used.
     * @return A Retrofit [Response] object for this API request.
     */
    @GET("?module=json&function=getBusTimes")
    suspend fun getBusTimes(
            @Query("key") hashedApiKey: String,
            @Query("nb") numberOfDepartures: Int?,
            @Query("stopId1") stopId1: String,
            @Query("stopId2") stopId2: String?,
            @Query("stopId3") stopId3: String?,
            @Query("stopId4") stopId4: String?,
            @Query("stopId5") stopId5: String?): Response<BusTimes>

    /**
     * Get bus times for a given [stopId]. This is a more enhanced version of the call, allowing the user to customise
     * all parameters. For a simpler version of this call, see [getBusTimes].
     *
     * @param hashedApiKey The hashed API key. See [ApiKeyGenerator].
     * @param numberOfDepartures The number of departures per service to return, between `1` and `10`. Set as `null` to
     * use the default value of `2`.
     * @param day The day offset, between `0` and `3`. Passing `null` uses the default value of `0`.
     * @param time The time to get bus times for, in the format of `HH:mm` (24 hour format). Passing `null` uses the
     * default value of now.
     * @param stopId The identifier of the stop.
     * @param serviceReference Only get bus times for this bus service. Pass `null` to use the default value to get all
     * services.
     * @param destinationReference Only get bus times for this destination. Pass `null` to use the default value to get
     * all destinations.
     * @param operatorId An optional operator ID to filter by. Pass `null` if the filter should not apply.
     * @return A Retrofit [Response] object for this API request.
     */
    @GET("?module=json&function=getBusTimes")
    suspend fun getBusTimes(
            @Query("key") hashedApiKey: String,
            @Query("nb") numberOfDepartures: Int?,
            @Query("day") day: Int?,
            @Query("time") time: String?,
            @Query("stopId") stopId: String,
            @Query("refService") serviceReference: String?,
            @Query("refDest") destinationReference: String?,
            @Query("operatorId") operatorId: String?): Response<BusTimes>

    /**
     * Get bus times for up to 5 stops. This is a more enhanced version of the call, allowing the user to customise all
     * parameters. For a more simpler version of this call, see [getBusTimes].
     *
     * @param hashedApiKey The hashed API key. See [ApiKeyGenerator].
     * @param numberOfDepartures The number of departures per service to return, between `1` and `10`. Set as `null` to
     * use the default value of `2`.
     * @param day The day offset, between `0` and `3`. Passing `null` uses the default value of `0`.
     * @param time The time to get bus times for, in the format of `HH:mm` (24 hour format). Passing `null` uses the
     * default value of now.
     * @param stopId1 The identifier of the 1st stop.
     * @param serviceReference1 Only get bus times for this bus service. Pass `null` to use the default value to get all
     * services.
     * @param destinationReference1 Only get bus times for this destination. Pass `null` to use the default value to get
     * all destinations.
     * @param operatorId1 An optional operator ID to filter by. Pass `null` if the filter should not apply.
     * @param stopId2 The identifier of the 2nd stop. Set as `null` if this should not be used.
     * @param serviceReference2 Only get bus times for this bus service. Pass `null` to use the default value to get all
     * services, or if `stopId2` is `null`.
     * @param destinationReference2 Only get bus times for this destination. Pass `null` to use the default value to get
     * all destinations, or if `stopId2` is `null`.
     * @param operatorId2 An optional operator ID to filter by. Pass `null` if the filter should not apply, or if
     * `stopId2` is `null`.
     * @param stopId3 The identifier of the 3rd stop. Set as `null` if this should not be used.
     * @param serviceReference3 Only get bus times for this bus service. Pass `null` to use the default value to get all
     * services, or if `stopId3` is `null`.
     * @param destinationReference3 Only get bus times for this destination. Pass `null` to use the default value to get
     * all destinations, or if `stopId3` is `null`.
     * @param operatorId3 An optional operator ID to filter by. Pass `null` if the filter should not apply, or if
     * `stopId3` is `null`.
     * @param stopId4 The identifier of the 4th stop. Set as `null` if this should not be used.
     * @param serviceReference4 Only get bus times for this bus service. Pass `null` to use the default value to get all
     * services, or if `stopId4` is `null`.
     * @param destinationReference4 Only get bus times for this destination. Pass `null` to use the default value to get
     * all destinations, or if `stopId4` is `null`.
     * @param operatorId4 An optional operator ID to filter by. Pass `null` if the filter should not apply, or if
     * `stopId4` is `null`.
     * @param stopId5 The identifier of the 5th stop. Set as `null` if this should not be used.
     * @param serviceReference5 Only get bus times for this bus service. Pass `null` to use the default value to get all
     * services, or if `stopId5` is `null`.
     * @param destinationReference5 Only get bus times for this destination. Pass `null` to use the default value to get
     * all destinations, or if `stopId5` is `null`.
     * @param operatorId5 An optional operator ID to filter by. Pass `null` if the filter should not apply, or if
     * `stopId5` is `null`.
     * @return A Retrofit [Response] object for this API request.
     */
    @GET("?module=json&function=getBusTimes")
    suspend fun getBusTimes(
            @Query("key") hashedApiKey: String,
            @Query("nb") numberOfDepartures: Int?,
            @Query("day") day: Int?,
            @Query("time") time: String?,
            @Query("stopId1") stopId1: String,
            @Query("refService1") serviceReference1: String?,
            @Query("refDest1") destinationReference1: String?,
            @Query("operatorId1") operatorId1: String?,
            @Query("stopId2") stopId2: String?,
            @Query("refService2") serviceReference2: String?,
            @Query("refDest2") destinationReference2: String?,
            @Query("operatorId2") operatorId2: String?,
            @Query("stopId3") stopId3: String?,
            @Query("refService3") serviceReference3: String?,
            @Query("refDest3") destinationReference3: String?,
            @Query("operatorId3") operatorId3: String?,
            @Query("stopId4") stopId4: String?,
            @Query("refService4") serviceReference4: String?,
            @Query("refDest4") destinationReference4: String?,
            @Query("operatorId4") operatorId4: String?,
            @Query("stopId5") stopId5: String?,
            @Query("refService5") serviceReference5: String?,
            @Query("refDest5") destinationReference5: String?,
            @Query("operatorId5") operatorId5: String?): Response<BusTimes>

    /**
     * Get journey times for a given [journeyId] departing from a given [stopId].
     *
     * @param hashedApiKey The hashed API key. See [ApiKeyGenerator].
     * @param stopId The identifier of the starting stop.
     * @param journeyId The journey ID. Obtainable from the [getBusTimes] API call.
     * @param busId The bus ID. This can be used instead of [journeyId].
     * @param operatorId An optional operator ID to filter by. Pass `null` if the filter should not apply.
     * @param day The day offset, between `0` and `3`. Passing `null` uses the default value of `0`.
     * @param mode Controls what type of data is returned.
     * @return A Retrofit [Response] object for this API request.
     */
    @GET("?module=json&function=getJourneyTimes")
    suspend fun getJourneyTimes(
            @Query("key") hashedApiKey: String,
            @Query("stopId") stopId: String?,
            @Query("journeyId") journeyId: String?,
            @Query("busId") busId: String?,
            @Query("operatorId") operatorId: String?,
            @Query("day") day: Int?,
            @Query("mode") mode: Int?): Response<JourneyTimes>
}
