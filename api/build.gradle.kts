/*
 * Copyright 2018 - 2023 Niall Scott
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
    id("maven-publish")
    id("signing")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    withJavadocJar()
    withSourcesJar()
}

tasks.javadoc {
    title = "Edinburgh Bus Tracker API"

    options {
        require(this is StandardJavadocDocletOptions)

        addStringOption("Xdoclint:none", "-quiet")

        if (JavaVersion.current().isJava9Compatible) {
            addBooleanOption("html5", true)
        }

        links("https://docs.oracle.com/javase/8/docs/api/")
        links("https://www.javadoc.io/doc/com.google.code.gson/gson/latest/com.google.gson/")
        links("https://square.github.io/retrofit/2.x/retrofit/")
    }
}

publishing {
    publications {
        maybeCreate<MavenPublication>("release").apply {
            artifactId = "api"
            from(components["java"])

            pom {
                name.set("Edinburgh Bus Tracker API - Java")
                packaging = "jar"
                description.set("A Java library which provides model objects and a RESTful interface to the " +
                    "Edinburgh Bus Tracker (My Bus Tracker) API.")
            }
        }
    }
}

dependencies {

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    // Okhttp
    implementation(libs.okhttp)

    // Gson
    implementation(libs.gson)

    // Test dependencies
    testImplementation(libs.junit)
}
