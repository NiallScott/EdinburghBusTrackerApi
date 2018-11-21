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

/**
 * This is the base package in this library. In here, you will find the entry point and utility classes.
 *
 * <p>
 *     This library is intended to be used with Retrofit 2. To access the Edinburgh Bus Tracker API, create a Retrofit
 *     service using the {@link uk.org.rivernile.edinburghbustrackerapi.EdinburghBusTrackerApi} interface. This will
 *     create a concrete version of this class at runtime for you.
 * </p>
 *
 * <p>
 *     See {@link uk.org.rivernile.edinburghbustrackerapi.ApiKeyGenerator} to generate a hashed API key for use with the
 *     API.
 * </p>
 *
 * @author Niall Scott
 */
package uk.org.rivernile.edinburghbustrackerapi;