plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    constraints {

    }
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
