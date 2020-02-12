plugins {
    kotlin("jvm") version "1.3.61"
}

allprojects {
    group = "me.freedom4live.konverter"
    version = "1.0-SNAPSHOT"

    apply(plugin = "kotlin")
    apply(plugin = "java")

    repositories {
        mavenCentral()
    }
}

subprojects {
    dependencies {
        implementation(kotlin("stdlib-jdk8"))

        testImplementation(kotlin("test-junit"))
        testImplementation("org.junit.jupiter:junit-jupiter:5.6.0")
    }

    tasks.test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }

    tasks {
        compileKotlin {
            kotlinOptions.jvmTarget = "1.8"
        }
        compileTestKotlin {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
}
