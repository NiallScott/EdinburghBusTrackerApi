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

package uk.org.rivernile.edinburghbustrackerapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import uk.org.rivernile.edinburghbustrackerapi.busstops.BusStops;
import uk.org.rivernile.edinburghbustrackerapi.bustimes.BusTimes;
import uk.org.rivernile.edinburghbustrackerapi.destinations.Destinations;
import uk.org.rivernile.edinburghbustrackerapi.disruptions.Disruptions;
import uk.org.rivernile.edinburghbustrackerapi.diversionpoints.DiversionPoints;
import uk.org.rivernile.edinburghbustrackerapi.diversions.Diversions;
import uk.org.rivernile.edinburghbustrackerapi.journeytimes.JourneyTimes;
import uk.org.rivernile.edinburghbustrackerapi.servicepoints.ServicePoints;
import uk.org.rivernile.edinburghbustrackerapi.services.Services;
import uk.org.rivernile.edinburghbustrackerapi.topoid.TopoId;

/**
 * This interface defines methods to interact with the Edinburgh Bus Tracker API. It's intended to be used by Retrofit 2
 * to create a concrete implementation at runtime.
 *
 * <p>
 *     Assuming you have created a {@link retrofit2.Retrofit} instance, then to obtain a concrete instance of this class
 *     simply call {@code retrofit.create(EdinburghBusTrackerApi.class)}.
 * </p>
 *
 * <p>
 *     All of the methods have a {@code hashedApiKey} parameter. Use the {@link ApiKeyGenerator} class to obtain a
 *     hashed API key and pass the resulting key in to the method you wish to use.
 * </p>
 *
 * <h3>
 *     Example
 * </h3>
 *
 * <p>
 *     Firstly, set up Okhttp and Retrofit;
 * </p>
 *
 * <pre>
 * <code>
 * final OkHttpClient client = new OkHttpClient.Builder()
 *     // Any other Okhttp customisations you wish to make should go here.
 *     .build();
 *
 * final Retrofit retrofit = new Retrofit.Builder()
 *     .baseUrl("http://ws.mybustracker.co.uk/")
 *     .client(client)
 *     .addConverterFactory(GsonConverterFactory.create()) // Our defined model should work fine with default Gson settings
 *     .build();
 * </code>
 * </pre>
 *
 * <p>
 *     Now obtain a concrete implementation of this class through your {@link retrofit2.Retrofit} instance;
 * </p>
 *
 * <pre>
 * <code>
 * final EdinburghBusTrackerApi api = retrofit.create(EdinburghBusTrackerApi.class);
 * </code>
 * </pre>
 *
 * <p>
 *     Create an instance of {@link ApiKeyGenerator} with your unhashed API key, supplied to you when you signed up for
 *     the Edinburgh Bus Tracker API. You can keep this instance for the lifetime of your application;
 * </p>
 *
 * <pre>
 * <code>
 * final ApiKeyGenerator keyGenerator = new ApiKeyGenerator("your API key goes here");
 * </code>
 * </pre>
 *
 * <p>
 *     You now have all the bits you need to make an API call. Here's an example;
 * </p>
 *
 * <pre>
 * <code>
 * // Get the current topology ID
 * try {
 *     final Response&lt;TopoId&gt; response = api.getTopoId(apiKeyForRequest, null).execute();
 *
 *     if (response.isSuccessful()) {
 *         final TopoId topoId = response.body();
 *
 *         if (topoId.getTopoId() != null) {
 *             // Now do whatever you want to do with this object, i.e. call some method.
 *             doOnTopoIdLoaded(topoId.getTopoId());
 *         } else {
 *             handleError(topoId.getFaultCode());
 *         }
 *     } else {
 *         // Handle error here
 *     }
 * } catch (IOException e) {
 *     // Deal with the thrown IOException.
 * }
 * </code>
 * </pre>
 *
 * <p>
 *     See the project README.md for more details.
 * </p>
 *
 * @author Niall Scott
 * @see ApiKeyGenerator
 */
public interface EdinburghBusTrackerApi {

    /**
     * Integer constant for {@link #getDisruptions(String, String, Integer)} to specify that all disruptions should be
     * returned.
     */
    int DISRUPTION_TYPE_ALL = 0;
    /**
     * Integer constant for {@link #getDisruptions(String, String, Integer)} to specify that only network disruptions
     * should be returned.
     */
    int DISRUPTION_TYPE_NETWORK = 1;
    /**
     * Integer constant for {@link #getDisruptions(String, String, Integer)} to specify that only service disruptions
     * should be returned.
     */
    int DISRUPTION_TYPE_SERVICE = 2;
    /**
     * Integer constant for {@link #getDisruptions(String, String, Integer)} to specify that only bus stop disruptions
     * should be returned.
     */
    int DISRUPTION_TYPE_BUS_STOP = 3;

    /**
     * Get the current topology ID.
     *
     * @param hashedApiKey The hashed API key. See {@link ApiKeyGenerator}.
     * @param operatorId An optional operator ID. Pass {@code null} if this should not be used.
     * @return A Retrofit {@link Call} object for this API request.
     */
    @GET("?module=json&function=getTopoId")
    Call<TopoId> getTopoId(@Query("key") String hashedApiKey,
                           @Query("operatorId") String operatorId);

    /**
     * Get details of all services known by the Edinburgh Bus Tracker API.
     *
     * @param hashedApiKey The hashed API key. See {@link ApiKeyGenerator}.
     * @param operatorId An optional operator ID to filter by. Pass {@code null} if the filter should not apply.
     * @return A Retrofit {@link Call} object for this API request.
     */
    @GET("?module=json&function=getServices")
    Call<Services> getServices(@Query("key") String hashedApiKey,
                               @Query("operatorId") String operatorId);

    /**
     * Get the service route lines for a given {@code serviceReference}.
     *
     * @param hashedApiKey The hashed API key. See {@link ApiKeyGenerator}.
     * @param operatorId An optional operator ID to filter by. Pass {@code null} if the filter should not apply. This is
     * probably useless here anyway.
     * @param serviceReference The service to get route lines for.
     * @return A Retrofit {@link Call} object for this API request.
     */
    @GET("?module=json&function=getServicePoints")
    Call<ServicePoints> getServicePoints(@Query("key") String hashedApiKey,
                                         @Query("operatorId") String operatorId,
                                         @Query("ref") String serviceReference);

    /**
     * Get details of all destinations known by the Edinburgh Bus Tracker API.
     *
     * @param hashedApiKey The hashed API key. See {@link ApiKeyGenerator}.
     * @param operatorId An optional operator ID to filter by. Pass {@code null} if the filter should not apply.
     * @return A Retrofit {@link Call} object for this API request.
     */
    @GET("?module=json&function=getDests")
    Call<Destinations> getDestinations(@Query("key") String hashedApiKey,
                                       @Query("operatorId") String operatorId);

    /**
     * Get details of all bus stops known by the Edinburgh Bus Tracker API.
     *
     * @param hashedApiKey The hashed API key. See {@link ApiKeyGenerator}.
     * @param operatorId An optional operator ID to filter by. Pass {@code null} if the filter should not apply.
     * @return A Retrofit {@link Call} object for this API request.
     */
    @GET("?module=json&function=getBusStops")
    Call<BusStops> getBusStops(@Query("key") String hashedApiKey,
                               @Query("operatorId") String operatorId);

    /**
     * Get details of disruptions.
     *
     * @param hashedApiKey The hashed API key. See {@link ApiKeyGenerator}.
     * @param operatorId An optional operator ID to filter by. Pass {@code null} if the filter should not apply.
     * @param type The type of disruption to get. {@code 0} = all disruptions (default - set {@code null} to use
     * default); {@code 1} = network disruption; {@code 2} = service disruption; {@code 3} = bus stop disruption.
     * @return A Retrofit {@link Call} object for this API request.
     */
    @GET("?module=json&function=getDisruptions")
    Call<Disruptions> getDisruptions(@Query("key") String hashedApiKey,
                                     @Query("operatorId") String operatorId,
                                     @Query("type") Integer type);

    /**
     * Get details of diversions.
     *
     * @param hashedApiKey The hashed API key. See {@link ApiKeyGenerator}.
     * @param operatorId An optional operator ID to filter by. Pass {@code null} if the filter should not apply.
     * @param serviceReference The service reference. Set as {@code null} to use the default option of all services.
     * @param day Day offset, between {@code 0} and {@code 3}. Set as {@code null} to use the default offset of
     * {@code 0}.
     * @return A Retrofit {@link Call} object for this API request.
     */
    @GET("?module=json&function=getDiversions")
    Call<Diversions> getDiversions(@Query("key") String hashedApiKey,
                                   @Query("operatorId") String operatorId,
                                   @Query("refService") String serviceReference,
                                   @Query("day") Integer day);

    /**
     * Get the diversions points for a given {@code diversionId}.
     *
     * @param hashedApiKey The hashed API key. See {@link ApiKeyGenerator}.
     * @param operatorId An optional operator ID to filter by. Pass {@code null} if the filter should not apply.
     * @param diversionId The ID of the diversion to get points for.
     * @return A Retrofit {@link Call} object for this API request.
     */
    @GET("?module=json&function=getDiversionPoints")
    Call<DiversionPoints> getDiversionPoints(@Query("key") String hashedApiKey,
                                             @Query("operatorId") String operatorId,
                                             @Query("diversionId") String diversionId);

    /**
     * Get bus times for a given {@code stopId}. This is a simpler version of the call, mostly using default values. The
     * more enhanced version of this call can be found at
     * {@link #getBusTimes(String, Integer, Integer, String, String, String, String, String)}.
     *
     * @param hashedApiKey The hashed API key. See {@link ApiKeyGenerator}.
     * @param numberOfDepartures The number of departures per service to return, between {@code 1} and {@code 10}. Set
     * as {@code null} to use the default value of {@code 2}.
     * @param stopId The identifier of the stop.
     * @return A Retrofit {@link Call} object for this API request.
     */
    @GET("?module=json&function=getBusTimes")
    Call<BusTimes> getBusTimes(@Query("key") String hashedApiKey,
                               @Query("nb") Integer numberOfDepartures,
                               @Query("stopId") String stopId);

    /**
     * Get bus times for up to 5 stops. This is a simpler version of the call, mostly using default values. The more
     * enhanced version of this call can be found at
     * {@link #getBusTimes(String, Integer, Integer, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String)}.
     *
     * @param hashedApiKey The hashed API key. See {@link ApiKeyGenerator}.
     * @param numberOfDepartures The number of departures per service to return, between {@code 1} and {@code 10}. Set
     * as {@code null} to use the default value of {@code 2}.
     * @param stopId1 The identifier of the 1st stop.
     * @param stopId2 The identifier of the 2nd stop. Set as {@code null} if this should not be used.
     * @param stopId3 The identifier of the 3rd stop. Set as {@code null} if this should not be used.
     * @param stopId4 The identifier of the 4th stop. Set as {@code null} if this should not be used.
     * @param stopId5 The identifier of the 5th stop. Set as {@code null} if this should not be used.
     * @return A Retrofit {@link Call} object for this API request.
     */
    @GET("?module=json&function=getBusTimes")
    Call<BusTimes> getBusTimes(@Query("key") String hashedApiKey,
                               @Query("nb") Integer numberOfDepartures,
                               @Query("stopId1") String stopId1,
                               @Query("stopId2") String stopId2,
                               @Query("stopId3") String stopId3,
                               @Query("stopId4") String stopId4,
                               @Query("stopId5") String stopId5);

    /**
     * Get bus times for a given {@code stopId}. This is a more enhanced version of the call, allowing the user to
     * customise all parameters. For a more simpler version of this call, see
     * {@link #getBusTimes(String, Integer, String)}.
     *
     * @param hashedApiKey The hashed API key. See {@link ApiKeyGenerator}.
     * @param numberOfDepartures The number of departures per service to return, between {@code 1} and {@code 10}. Set
     * as {@code null} to use the default value of {@code 2}.
     * @param day The day offset, between {@code 0} and {@code 3}. Passing {@code null} uses the default value of
     * {@code 0}.
     * @param time The time to get bus times for, in the format of {@code HH:mm} (24 hour format). Passing {@code null}
     * uses the default value of now.
     * @param stopId The identifier of the stop.
     * @param serviceReference Only get bus times for this bus service. Pass {@code null} to use the default value to
     * get all services.
     * @param destinationReference Only get bus times for this destination. Pass {@code null} to use the default value
     * to get all destinations.
     * @param operatorId An optional operator ID to filter by. Pass {@code null} if the filter should not apply.
     * @return A Retrofit {@link Call} object for this API request.
     */
    @GET("?module=json&function=getBusTimes")
    Call<BusTimes> getBusTimes(@Query("key") String hashedApiKey,
                               @Query("nb") Integer numberOfDepartures,
                               @Query("day") Integer day,
                               @Query("time") String time,
                               @Query("stopId") String stopId,
                               @Query("refService") String serviceReference,
                               @Query("refDest") String destinationReference,
                               @Query("operatorId") String operatorId);

    /**
     * Get bus times for up to 5 stops. This is a more enhanced version of the call, allowing the user to customise all
     * parameters. For a more simpler version of this call, see
     * {@link #getBusTimes(String, Integer, String, String, String, String, String)}.
     *
     * @param hashedApiKey The hashed API key. See {@link ApiKeyGenerator}.
     * @param numberOfDepartures The number of departures per service to return, between {@code 1} and {@code 10}. Set
     * as {@code null} to use the default value of {@code 2}.
     * @param day The day offset, between {@code 0} and {@code 3}. Passing {@code null} uses the default value of
     * {@code 0}.
     * @param time The time to get bus times for, in the format of {@code HH:mm} (24 hour format). Passing {@code null}
     * uses the default value of now.
     * @param stopId1 The identifier of the 1st stop.
     * @param serviceReference1 Only get bus times for this bus service. Pass {@code null} to use the default value to
     * get all services.
     * @param destinationReference1 Only get bus times for this destination. Pass {@code null} to use the default value
     * to get all destinations.
     * @param operatorId1 An optional operator ID to filter by. Pass {@code null} if the filter should not apply.
     * @param stopId2 The identifier of the 2nd stop. Set as {@code null} if this should not be used.
     * @param serviceReference2 Only get bus times for this bus service. Pass {@code null} to use the default value to
     * get all services, or if {@code stopId2} is {@code null}.
     * @param destinationReference2 Only get bus times for this destination. Pass {@code null} to use the default value
     * to get all destinations, or if {@code stopId2} is {@code null}.
     * @param operatorId2 An optional operator ID to filter by. Pass {@code null} if the filter should not apply, or if
     * {@code stopId2} is {@code null}.
     * @param stopId3 The identifier of the 3rd stop. Set as {@code null} if this should not be used.
     * @param serviceReference3 Only get bus times for this bus service. Pass {@code null} to use the default value to
     * get all services, or if {@code stopId3} is {@code null}.
     * @param destinationReference3 Only get bus times for this destination. Pass {@code null} to use the default value
     * to get all destinations, or if {@code stopId3} is {@code null}.
     * @param operatorId3 An optional operator ID to filter by. Pass {@code null} if the filter should not apply, or if
     * {@code stopId3} is {@code null}.
     * @param stopId4 The identifier of the 4th stop. Set as {@code null} if this should not be used.
     * @param serviceReference4 Only get bus times for this bus service. Pass {@code null} to use the default value to
     * get all services, or if {@code stopId4} is {@code null}.
     * @param destinationReference4 Only get bus times for this destination. Pass {@code null} to use the default value
     * to get all destinations, or if {@code stopId4} is {@code null}.
     * @param operatorId4 An optional operator ID to filter by. Pass {@code null} if the filter should not apply, or if
     * {@code stopId4} is {@code null}.
     * @param stopId5 The identifier of the 5th stop. Set as {@code null} if this should not be used.
     * @param serviceReference5 Only get bus times for this bus service. Pass {@code null} to use the default value to
     * get all services, or if {@code stopId5} is {@code null}.
     * @param destinationReference5 Only get bus times for this destination. Pass {@code null} to use the default value
     * to get all destinations, or if {@code stopId5} is {@code null}.
     * @param operatorId5 An optional operator ID to filter by. Pass {@code null} if the filter should not apply, or if
     * {@code stopId5} is {@code null}.
     * @return A Retrofit {@link Call} object for this API request.
     */
    @GET("?module=json&function=getBusTimes")
    Call<BusTimes> getBusTimes(@Query("key") String hashedApiKey,
                               @Query("nb") Integer numberOfDepartures,
                               @Query("day") Integer day,
                               @Query("time") String time,
                               @Query("stopId1") String stopId1,
                               @Query("refService1") String serviceReference1,
                               @Query("refDest1") String destinationReference1,
                               @Query("operatorId1") String operatorId1,
                               @Query("stopId2") String stopId2,
                               @Query("refService2") String serviceReference2,
                               @Query("refDest2") String destinationReference2,
                               @Query("operatorId2") String operatorId2,
                               @Query("stopId3") String stopId3,
                               @Query("refService3") String serviceReference3,
                               @Query("refDest3") String destinationReference3,
                               @Query("operatorId3") String operatorId3,
                               @Query("stopId4") String stopId4,
                               @Query("refService4") String serviceReference4,
                               @Query("refDest4") String destinationReference4,
                               @Query("operatorId4") String operatorId4,
                               @Query("stopId5") String stopId5,
                               @Query("refService5") String serviceReference5,
                               @Query("refDest5") String destinationReference5,
                               @Query("operatorId5") String operatorId5);

    /**
     * Get journey times for a given {@code journeyId} departing from a given {@code stopId}.
     *
     * @param hashedApiKey The hashed API key. See {@link ApiKeyGenerator}.
     * @param stopId The identifier of the starting stop.
     * @param journeyId The journey ID. Obtainable from the {@code getBusTimes} API call.
     * @param busId The bus ID. This can be used instead of {@code journeyId}.
     * @param operatorId An optional operator ID to filter by. Pass {@code null} if the filter should not apply.
     * @param day The day offset, between {@code 0} and {@code 3}. Passing {@code null} uses the default value of
     * {@code 0}.
     * @param mode Controls what type of data is returned.
     * @return A Retrofit {@link Call} object for this API request.
     */
    @GET("?module=json&function=getJourneyTimes")
    Call<JourneyTimes> getJourneyTimes(@Query("key") String hashedApiKey,
                                       @Query("stopId") String stopId,
                                       @Query("journeyId") String journeyId,
                                       @Query("busId") String busId,
                                       @Query("operatorId") String operatorId,
                                       @Query("day") Integer day,
                                       @Query("mode") Integer mode);
}
