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

plugins {
    kotlin("jvm")
    application
}

val mainClassName = "uk.org.rivernile.edinburghbustrackerapi.playground.MainKt"

application {
    mainClass.set(mainClassName)
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to mainClassName)
    }
}

dependencies {

    implementation(project(":api-kt"))

    // Coroutines
    implementation(libs.kotlin.coroutines)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.kotlin.serialization)

    // Okhttp
    implementation(libs.okhttp)

    // Kotlin Serialization
    implementation(libs.kotlin.serialization)
}
