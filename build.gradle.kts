plugins {
    kotlin("jvm") version "1.9.0"
}

sourceSets {
    main {
        kotlin.srcDir("src")
    }
}

tasks {
    wrapper {
        gradleVersion = "8.3.0"
    }
}
