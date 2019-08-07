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

package uk.org.rivernile.edinburghbustrackerapi.playground;

import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.org.rivernile.edinburghbustrackerapi.ApiKeyGenerator;
import uk.org.rivernile.edinburghbustrackerapi.EdinburghBusTrackerApi;
import uk.org.rivernile.edinburghbustrackerapi.bustimes.BusTimes;
import uk.org.rivernile.edinburghbustrackerapi.services.Services;
import uk.org.rivernile.edinburghbustrackerapi.topoid.TopoId;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {

    private ApiKeyGenerator keyGenerator;

    public static void main(final String[] args) {
        final String apiKey = args.length > 0 ? args[0] : null;

        if (apiKey != null && !apiKey.isEmpty()) {
            new Main(apiKey).runPlayground();
        } else {
            System.err.println("The API key was not provided. Exiting.");
        }
    }

    private Main(final String apiKey) {
        keyGenerator = new ApiKeyGenerator(apiKey);
    }

    private void runPlayground() {
        final String hashedKey = getKey();
        System.out.println("Running playground. Hashed key = " + hashedKey);

        final EdinburghBusTrackerApi api = createApi();

        doGetTopoId(api);
        doGetServices(api);
        doGetBusTimes(api);
    }

    private EdinburghBusTrackerApi createApi() {
        final OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .followRedirects(false)
                .build();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ws.mybustracker.co.uk/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EdinburghBusTrackerApi.class);
    }

    private String getKey() {
        return keyGenerator.getHashedApiKey();
    }

    private void doGetTopoId(final EdinburghBusTrackerApi api) {
        try {
            final Response<TopoId> response = api.getTopoId(getKey(), null).execute();

            if (response.isSuccessful()) {
                System.out.println("doGetTopoId(): Success response.");
                System.out.println(response.body());
            } else {
                System.out.println("doGetTopoId(): Failure response.");
                System.out.println(response.errorBody());
            }
        } catch (IOException e) {
            System.out.println("Failed to talk to server. Error = " + e.toString());
        }
    }

    private void doGetServices(final EdinburghBusTrackerApi api) {
        try {
            final Response<Services> response = api.getServices(getKey(), null).execute();

            if (response.isSuccessful()) {
                System.out.println("doGetServices(): Success response.");
                System.out.println(response.body());
            } else {
                System.out.println("doGetServices(): Failure response.");
                System.out.println(response.errorBody());
            }
        } catch (IOException e) {
            System.out.println("Failed to talk to server. Error = " + e.toString());
        }
    }

    private void doGetBusTimes(final EdinburghBusTrackerApi api) {
        try {
            final Response<BusTimes> response = api.getBusTimes(getKey(), 4, "36243252").execute();

            if (response.isSuccessful()) {
                System.out.println("doGetBusTimes(): Success response.");
                System.out.println(response.body());
            } else {
                System.out.println("doGetBusTimes(): Failure response.");
                System.out.println(response.errorBody());
            }
        } catch (IOException e) {
            System.out.println("Failed to talk to server. Error = " + e.toString());
        }
    }
}
