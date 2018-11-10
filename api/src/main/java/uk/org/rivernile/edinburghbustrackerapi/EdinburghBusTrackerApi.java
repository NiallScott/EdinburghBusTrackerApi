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

public interface EdinburghBusTrackerApi {

    @GET("?module=json&function=getTopoId")
    Call<TopoId> getTopoId(@Query("key") String key,
                           @Query("operatorId") String operatorId);

    @GET("?module=json&function=getServices")
    Call<Services> getServices(@Query("key") String key,
                               @Query("operatorId") String operatorId);

    @GET("?module=json&function=getServicePoints")
    Call<ServicePoints> getServicePoints(@Query("key") String key,
                                         @Query("operatorId") String operatorId,
                                         @Query("ref") String serviceReference);

    @GET("?module=json&function=getDests")
    Call<Destinations> getDestinations(@Query("key") String key,
                                       @Query("operatorId") String operatorId);

    @GET("?module=json&function=getBusStops")
    Call<BusStops> getBusStops(@Query("key") String key,
                               @Query("operatorId") String operatorId);

    @GET("?module=json&function=getDisruptions")
    Call<Disruptions> getDisruptions(@Query("key") String key,
                                     @Query("operatorId") String operatorId,
                                     @Query("type") int type);

    @GET("?module=json&function=getDiversions")
    Call<Diversions> getDiversions(@Query("key") String key,
                                   @Query("operatorId") String operatorId,
                                   @Query("refService") String serviceReference,
                                   @Query("day") int day);

    @GET("?module=json&function=getDiversionPoints")
    Call<DiversionPoints> getDiversionPoints(@Query("key") String key,
                                             @Query("operatorId") String operatorId,
                                             @Query("diversionId") String diversionId);

    @GET("?module=json&function=getBusTimes")
    Call<BusTimes> getBusTimes(@Query("key") String key,
                               @Query("nb") Integer numberOfDepartures,
                               @Query("stopId") String stopId);

    @GET("?module=json&function=getBusTimes")
    Call<BusTimes> getBusTimes(@Query("key") String key,
                               @Query("nb") Integer numberOfDepartures,
                               @Query("stopId1") String stopId1,
                               @Query("stopId2") String stopId2,
                               @Query("stopId3") String stopId3,
                               @Query("stopId4") String stopId4,
                               @Query("stopId5") String stopId5);

    @GET("?module=json&function=getBusTimes")
    Call<BusTimes> getBusTimes(@Query("key") String key,
                               @Query("nb") Integer numberOfDepartures,
                               @Query("day") Integer day,
                               @Query("time") String time,
                               @Query("stopId") String stopId,
                               @Query("refService") String serviceReference,
                               @Query("refDest") String destinationReference,
                               @Query("operatorId") String operatorId);

    @GET("?module=json&function=getBusTimes")
    Call<BusTimes> getBusTimes(@Query("key") String key,
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

    @GET("?module=json&function=getJourneyTimes")
    Call<JourneyTimes> getJourneyTimes(@Query("key") String key,
                                       @Query("stopId") String stopId,
                                       @Query("journeyId") String journeyId,
                                       @Query("operatorId") String operatorId,
                                       @Query("day") Integer day);
}
