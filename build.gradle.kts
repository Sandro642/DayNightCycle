plugins {
    id("java")
}

group = "fr.sandro642.github"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    compileOnly("org.spigotmc:spigot-api:1.20.2-R0.1-SNAPSHOT") // The Spigot API with no shadowing. Requires the OSS repo.
}

tasks.test {
    useJUnitPlatform()
}