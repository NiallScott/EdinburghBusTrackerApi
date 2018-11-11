[![CircleCI](https://circleci.com/gh/NiallScott/EdinburghBusTrackerApi/tree/master.svg?style=svg)](https://circleci.com/gh/NiallScott/EdinburghBusTrackerApi/tree/master)

Edinburgh Bus Tracker API (Java)
================================

A Java library which provides model objects and a RESTful interface to the Edinburgh Bus Tracker
([My Bus Tracker](http://mybustracker.co.uk/)) API.

This library is based on [Retrofit 2](https://square.github.io/retrofit/) and
[Okhttp 3](http://square.github.io/okhttp/) provided by Square.

This library is guaranteed to work on Android.

Usage examples
--------------

While this library is opinionated about what HTTP libraries should be used, it's not opinionated about how they should
be used. As such, there is no fancy wrapper around Retrofit. Just use Retrofit how you would normally use it.

All interactions with the My Bus Tracker API must include a hashed API key. The unhashed version is provided to you when
you sign up for access to the API. A utility class has been included in this library to hash the key correctly for you;

```java
final ApiKeyGenerator keyGenerator = new ApiKeyGenerator("<your API key goes here>");
```

This object may live for the lifetime of your application. Infact, it's preferable to only create it once and then
dependency inject it to wherever it is required.

To get the hashed API key, then this is all that's required;

```java
final Date timeNow = new Date();
final String apiKeyForRequest = keyGenerator.getHashedApiKey(timeNow);
```

To get an instance of `EdinburghBusTrackerApi`, which is the Retrofit service instance used to access the API, then the
follow setup is required (tip: this should be used in tandem with your dependency injection framework);

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

Now we have the ability to talk with the API, here's a couple of examples (synchronous calls are used for the examples,
but asynchronous calls will work fine too);

```java
// Get the current topology ID
try {
    final Response<TopoId> response = api.getTopoId(apiKeyForRequest, null).execute();

    if (response.isSuccessful()) {
        final TopoId topoId = response.body();
        // Now do whatever you want to do with this object, i.e. call some method.
        doOnTopoIdLoaded(topoId);
    } else {
        // Handle error here
    }
} catch (IOException e) {
    // Deal with the thrown IOException.
}
```

```java
// Get bus times
try {
    // Request 4 departures for each service at stop with code "123456".
    final Response<BusTimes> response = api.getBusTimes(apiKeyForRequest, 4, "123456");
    
    if (response.isSuccessful()) {
        final BusTimes busTimes = response.body();
        // Now do whatever you want to do with this object, i.e. call some method.
        doOnBusTimesLoaded(busTimes);
    } else {
        // Handle error here.
    }
} catch (IOException e) {
    // Deal with the thrown IOException.
}
```

Java version
------------

This library is written against Java 8.

On Android environments, the build tools should automatically make the bytecode compatible with the minimum supported
SDK version. As the Android tools only provide language support but not Java 8 library support (for example, the stream
API), this library will be written with this in mind. More about Android Java 8 support can be found here:
https://developer.android.com/studio/write/java8-support

Kotlin?
-------

This library should work just fine with Kotlin. If there's any issue, then please report it.

The reason the library was not written in Kotlin is to keep it lightweight. Kotlin requires its standard library is
included as a dependency wherever it's used. While this would be fine within codebases where Kotlin is already used, it
would bloat up a deployment if Kotlin is not being used there.

Javadoc
-------

There is no Javadoc yet. This will become available later.

License
-------

```
Copyright 2018 Niall Scott

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