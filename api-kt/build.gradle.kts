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
    `java-library`
    kotlin("jvm")
    id("kotlinx-serialization")
    id("maven-publish")
    id("signing")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    //withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        maybeCreate<MavenPublication>("release").apply {
            artifactId = "api-kt"
            from(components["java"])

            pom {
                name.set("Edinburgh Bus Tracker API - Kotlin")
                packaging = "jar"
                description.set("A Kotlin library which provides model objects and a RESTful interface to the " +
                    "Edinburgh Bus Tracker (My Bus Tracker) API.")
            }
        }
    }
}

dependencies {

    // Coroutines
    implementation(libs.kotlin.coroutines)

    // Retrofit
    implementation(libs.retrofit)

    // Okhttp
    implementation(libs.okhttp)

    // Kotlin Serialization
    implementation(libs.kotlin.serialization)

    // Kotlin Datetime
    implementation(libs.kotlin.datetime)

    // Test dependencies
    testImplementation(libs.junit)
}
