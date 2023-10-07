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

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed, possibly in Gradle 8.1
plugins {
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    base
}

subprojects {

    group = project.findProperty("GROUP")?.toString()
        ?: throw IllegalStateException("The Maven group has not been specified.")
    version = project.findProperty("VERSION_NAME")?.toString()
        ?: throw IllegalStateException("The Maven version has not been specified.")

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
    }

    plugins.withType<MavenPublishPlugin>().configureEach {
        extensions.configure<PublishingExtension> {
            repositories {
                maven {
                    name = "mavenCentral"
                    val releaseUrl = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
                    val snapshotUrl = uri("https://oss.sonatype.org/content/repositories/snapshots/")
                    url = if (version.toString().endsWith("SNAPSHOT")) snapshotUrl else releaseUrl

                    credentials {
                        username = findProperty("NEXUS_USERNAME")?.toString() ?: ""
                        password = findProperty("NEXUS_PASSWORD")?.toString() ?: ""
                    }
                }

                // When a dry-run location is provided, a publish task is created which allows us to publish to the
                // specified dry-run location on the local machine. This allows us to safely test Maven pushes without
                // affecting real repositories.
                //
                // To supply this property, either pass it in as a command-line argument to gradlew, or define it in
                // ~/.gradle/gradle.properties, e.g.; dryRunLocation=/home/users/dryrunmavenrepo/
                val dryRunLocation: String? by project

                dryRunLocation?.let { location ->
                    maven {
                        name = "dryRun"
                        url = uri("file://$location")
                    }
                }
            }

            publications {
                maybeCreate<MavenPublication>("release").apply {
                    pom {
                        url.set("https://github.com/NiallScott/EdinburghBusTrackerApi")

                        developers {
                            developer {
                                id.set("NiallScott")
                                name.set("Niall Scott")
                            }
                        }

                        scm {
                            url.set("https://github.com/NiallScott/EdinburghBusTrackerApi")
                            connection.set("scm:git@github.com:NiallScott/EdinburghBusTrackerApi.git")
                            developerConnection.set("scm:git@github.com:NiallScott/EdinburghBusTrackerApi.git")
                        }

                        licenses {
                            license {
                                name.set("The Apache Software License, Version 2.0")
                                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                                distribution.set("repo")
                            }
                        }
                    }
                }
            }
        }
    }

    plugins.withType<SigningPlugin>().configureEach {
        extensions.configure<SigningExtension> {
            isRequired = !version.toString().endsWith("SNAPSHOT")

            project
                .extensions
                .findByType<PublishingExtension>()
                ?.publications
                ?.getByName("release")
                ?.let {
                    sign(it)
                }
        }
    }
}
