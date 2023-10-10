[![GitHub Actions](https://github.com/NiallScott/EdinburghBusTrackerApi/actions/workflows/push-and-pull-request.yml/badge.svg)](https://github.com/NiallScott/EdinburghBusTrackerApi/actions/workflows/push-and-pull-request.yml)

# Edinburgh Bus Tracker API (Java)

Java and Kotlin libraries which provide model objects and a RESTful interface to the Edinburgh Bus Tracker
([My Bus Tracker](http://mybustracker.co.uk/)) API.

These libraries are based on [Retrofit 2](https://square.github.io/retrofit/) and
[Okhttp 4](http://square.github.io/okhttp/) provided by Square.

These libraries are guaranteed to work on Android - please ensure you are using the latest Android tooling to guarantee
compatibility.

## Languages

### Java

The Java library is written against Java 8.

De-serialisation is performed by [Gson](https://github.com/google/gson).

On Android environments, the build tools should automatically make the bytecode compatible with the minimum supported
SDK version. As the Android tools only provide language support but not Java 8 library support (for example, the stream
API), this library will be written with this in mind. More about Android Java 8 support can be found here:
https://developer.android.com/studio/write/java8-support

While this library is targeted at Android users, Kotlin users can use this library if they do not wish to use
Coroutines, and/or they wish to use Gson instead.

The Java version can be obtained from Maven Central.

```
Group ID: uk.org.rivernile.edinburghbustrackerapi
Artifact ID: api
Version: 1.3.0
```

For example, to bring the library in as a Gradle dependency;

`implementation 'uk.org.rivernile.edinburghbustrackerapi:api:1.3.0'`

### Kotlin

The Kotlin version of the library is distributed as a separate artifact as it has different dependencies to the Java
version.

De-serialisation is performed by [Kotlin Serialization](https://github.com/Kotlin/kotlinx.serialization). Also, this
library uses [Kotlin Coroutines](https://github.com/Kotlin/kotlinx.coroutines) which makes it incompatible with Java
code.

On Android environments, please ensure you are using the latest tooling.

Only Kotlin on the JVM is supported due to the dependence upon Retrofit.

The Kotlin version can be obtained from Maven Central.

```
Group ID: uk.org.rivernile.edinburghbustrackerapi
Artifact ID: api-kt
Version: 1.3.0
```

For example, to bring the library in as a Gradle dependency;

`implementation 'uk.org.rivernile.edinburghbustrackerapi:api-kt:1.3.0'`

## Accessing the API

This is an unofficial library used to access the API. As such, the maintainer is unable to help you gain access.

However, the official place to request an API key is here: http://mybustracker.co.uk/?page=API%20Key

Please don't contact the library maintainer for help accessing the API - I am unable to help beyond what's written in
this README.

## Usage examples

While this library is opinionated about what HTTP libraries should be used, it's not opinionated about how they should
be used. As such, there is no fancy wrapper around Retrofit. Just use Retrofit how you would normally use it.

All interactions with the My Bus Tracker API must include a hashed API key. The unhashed version is provided to you when
you sign up for access to the API. A utility class has been included in this library to hash the key correctly for you;

#### Java

```java
final ApiKeyGenerator keyGenerator = new ApiKeyGenerator("<your API key goes here>");
```

#### Kotlin

```kotlin
val keyGenerator = ApiKeyGenerator("<your API key goes here>")
```

This object may live for the lifetime of your application. Infact, it's preferable to only create it once and then
dependency inject it to wherever it is required.

To get the hashed API key, then this is all that's required;

#### Java

```java
final String apiKeyForRequest = keyGenerator.getHashedApiKey();
```

#### Kotlin
```kotlin
val apiKeyForRequest = keyGenerator.hashedApiKey
```

To get an instance of `EdinburghBusTrackerApi`, which is the Retrofit service instance used to access the API, then the
follow setup is required (tip: this should be used in tandem with your dependency injection framework);

#### Java

```java
final OkHttpClient client = new OkHttpClient.Builder()
    // Any other Okhttp customisations you wish to make should go here.
    .build();

final Retrofit retrofit = new Retrofit.Builder()
    .baseUrl("http://ws.mybustracker.co.uk/")
    .client(client)
    .addConverterFactory(GsonConverterFactory.create()) // Our defined model should work fine with default Gson settings
    .build();

final EdinburghBusTrackerApi api = retrofit.create(EdinburghBusTrackerApi.class);
```

#### Kotlin

```kotlin
val client = OkHttpClient.Builder()
    // Any other Okhttp customisations you wish to make should go here.
    .build()

val json = Json { ignoreUnknownKeys = true }

val retrofit = Retrofit.Builder()
    .baseUrl("http://ws.mybustracker.co.uk/")
    .client(client)
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .build()

val api = retrofit.create<EdinburghBusTrackerApi>()
```

Now we have the ability to talk with the API, here's a couple of examples (synchronous calls are used for the Java
examples, but asynchronous calls will work fine too);

### Get the topology ID

#### Java

```java
// Get the current topology ID
try {
    final Response<TopoId> response = api.getTopoId(apiKeyForRequest, null).execute();

    if (response.isSuccessful()) {
        final TopoId topoId = response.body();

        if (topoId.getTopoId() != null) {
            // Now do whatever you want to do with this object, i.e. call some method.
            doOnTopoIdLoaded(topoId.getTopoId());
        } else {
            handleError(topoId.getFaultCode());
        }
    } else {
        // Handle error here
    }
} catch (IOException e) {
    // Deal with the thrown IOException.
}
```

#### Kotlin

```kotlin
try {
    // The next line is a coroutine call. Retrofit runs this on Dispatchers.IO for you already.
    val response = api.getTopoId(keyGenerator.hashedApiKey, null)

    if (response.isSuccessful) {
        val topoId = response.body()

        if (topoId.topoId != null) {
            // Now do whatever you want to do with this object, i.e. call some method.
            doOnTopoIdLoaded(topoId.topoId)
        } else {
            handleError(topoId.faultCode)
        }
    } else {
        // Handle the error case.
    }
} catch (e: IOException) {
    // Deal with the thrown IOException.
} catch (e: SerializationException) {
    // Deal with the thrown SerializationException.
}
```

### Get bus times

#### Java

```java
// Get bus times
try {
    // Request 4 departures for each service at stop with code "123456".
    final Response<BusTimes> response = api.getBusTimes(apiKeyForRequest, 4, "123456").execute();

    if (response.isSuccessful()) {
        final BusTimes busTimes = response.body();

        if (busTimes.getBusTimes() != null) {
            // Now do whatever you want to do with this object, i.e. call some method.
            doOnBusTimesLoaded(busTimes);
        } else {
            handleError(busTimes.getFaultCode());
        }
    } else {
        // Handle error here.
    }
} catch (IOException e) {
    // Deal with the thrown IOException.
}
```

#### Kotlin

```kotlin
try {
    // Request 4 departures for each service at stop with code "123456".
    // The next line is a coroutine call. Retrofit runs this on Dispatchers.IO for you already.
    val response = api.getBusTimes(keyGenerator.hashedApiKey, 4, "123456")

    if (response.isSuccessful) {
        val busTimes = response.body()

        if (busTimes.busTimes != null) {
            // Now do whatever you want to do with this object, i.e. call some method.
            doOnBusTimesLoaded(busTimes)
        } else {
            handleError(busTimes.faultCode)
        }
    } else {
        // Handle error here.
    }
} catch (e: IOException) {
    // Deal with the thrown IOException.
} catch (e: SerializationException) {
    // Deal with the thrown SerializationException.
}
```

## Error handling

Unfortunately, the Edinburgh Bus Tracker API is not strictly RESTful. All responses from the API are returned as HTTP
200 OK, regardless if the request succeeded or failed. This means that the response types returned from the methods in
the `EdinburghBusTrackerApi` interface return model objects which encapsulate both success and failure cases.

All of these root model objects (such as `BusTimes`, `BusStops` etc) contain two methods/properties;

- `getFaultCode() / faultCode`: A string constant defining the error type. See the `FaultCode` class for the enumeration
  of these errors. This class also has a method, `convertFromString(String)` to convert the error in to its friendly
  enum type.
- `getFaultString() / faultString`: A string to describe the error in more detail. This may help during development or
  debugging to work out the root cause of the error. However, these errors are unfriendly to show to end users.

There's a few classes of errors to be aware of;

- You may receive an `IOException`. This means a network-level error has occurred. This should be handled appropriately.
- The `Response` object provided to you by Retrofit may return `false` when `Request.isSuccessful()` has been called.
  This would be unexpected given that the API returns `200 OK` for all responses, as discussed above. This should still
  be called as this could possibly be the case, and your implementation should guard against this. It is unlikely to
  yield any interesting information to debug with. It is possible this behaviour may be changed in the future. As such,
  this library will be updated when it does.
- The `getFaultCode() / faultCode` method/property, as discussed above, may be non-`null`. This should be handled.

Using the synchronous access method for Retrofit, your typical error handling may look like this;

#### Java (synchronous)

```java
// Get bus times
try {
    // Request 4 departures for each service at stop with code "123456".
    final Response<BusTimes> response = api.getBusTimes(apiKeyForRequest, 4, "123456").execute();

    if (response.isSuccessful()) {
        final BusTimes busTimes = response.body();
        final String faultCode = busTimes.getFaultCode();

        if (faultCode == null) {
            // Now do whatever you want to do with this object, i.e. call some method.
            doOnBusTimesLoaded(busTimes);
        } else {
            handleApiError(faultCode);
        }
    } else {
        // This isn't really expected, so perhaps handle it generically? It's up to you.
        handleGenericError();
    }
} catch (IOException e) {
    // This is called when a network-level error has occurred. This should be handled.
    handleIoError(e);
}
```

#### Java (asynchronous)

```java
// Get bus times
api.getBusTimes(apiKeyForRequest, 4, "123456").enqueue(new Callback<BusTimes>() {
    @Override
    public void onResponse(final Call<BusTimes> call, final Response<BusTimes> response) {
        if (response.isSuccessful()) {
            final BusTimes busTimes = response.body();
            final String faultCode = busTimes.getFaultCode();

            if (faultCode == null) {
                // Now do whatever you want to do with this object, i.e. call some method.
                doOnBusTimesLoaded(busTimes);
            } else {
                handleApiError(faultCode);
            }
        } else {
            // This isn't really expected, so perhaps handle it generically? It's up to you.
            handleGenericError();
        }
    }

    @Override
    public void onFailure(final Call<BusTimes> call, final Throwable t) {
        // This is called when a network-level or system error has occurred. This should be handled.
        handleThrowable(t);
    }
});
```

#### Kotlin (Coroutines)

```kotlin
// Get bus times
try {
    // Request 4 departures for each service at stop with code "123456".
    val response = api.getBusTimes(apiKeyForRequest, 4, "123456")

    if (response.isSuccessful) {
        val busTimes = response.body()
        val faultCode = busTimes.faultCode

        if (faultCode == null) {
            // Now do whatever you want to do with this object, i.e. call some method.
            doOnBusTimesLoaded(busTimes)
        } else {
            handleApiError(faultCode)
        }
    } else {
        // This isn't really expected, so perhaps handle it generically? It's up to you.
        handleGenericError()
    }
} catch (e: IOException) {
    // This is called when a network-level error has occurred. This should be handled.
    handleIoError(e)
} catch (e: SerializationException) {
    // This is called when the data could not be de-serialised. This should be handled.
    handleDeserialisationError(e)
}
```

## Javadoc / Kotlin Doc (Dokka)

Java: https://www.javadoc.io/doc/uk.org.rivernile.edinburghbustrackerapi/api/latest/index.html

Kotlin: https://www.javadoc.io/doc/uk.org.rivernile.edinburghbustrackerapi/api-kt/latest/index.html

## Public interfaces (and ongoing maintenance)

Unlike most libraries you will find, this library will not make any attempt to be backwards compatible to any previous
release. So if the Edinburgh Bus Tracker API changes, then so does this library's public interfaces. This will be
communicated through the release notes, but not in code or through deprecation annotations.

The reason for this is simple. This library is just a thin layer to access the Edinburgh Bus Tracker API using
Retrofit/Okhttp. It's designed to map closely to the API itself. If the goal was to maintain backwards compatibility and
let's say the API changed, then it would create a maintenance headache to keep the backwards compatibility.

In your own codebase, you should have model objects which represent the data you need, and you write mappers between the
objects/data returned by this library and convert them in to your own model objects. This way, if this library does
change its public interfaces, you only need to make the change in one place in your codebase, rather than modifying many
layers.

In terms of ongoing maintenance, it will be endeavoured to update this library as quickly as possible after any
Edinburgh Bus Tracker API changes have been made, but given this is a free, open source library, there is no obligation
on the author to do this or do it within a given time.

## Project structure

There are four modules in this project;

- `:api`: This is the distributed Java library.
- `:api-kt`: This is the distributed Kotlin library.
- `:playground`: This is a module used to play with the Java API module to test it out and make sure it works with the
  Edinburgh Bus Tracker API. It is not distributed with the library.
- `:playground-kt`: This is a module used to play with the Kotlin API module to test it out and make sure it works with
  the Edinburgh Bus Tracker API. It is not distributed with the library.

In the `:api` and `:api-kt` modules, the top-level package is `uk.org.rivernile.edinburghbustrackerapi`. The classes in
this package are used as entry-points and utility classes. In the child packages are the model objects returned by the
API calls, organised in to a child package per API method.

## License

```
Copyright 2018 - 2023 Niall Scott

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
