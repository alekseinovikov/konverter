plugins {
    base
    kotlin("jvm") version "1.3.61"
    jacoco
}

group = "org.konverter"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    jacocoTestReport {
        subprojects.forEach {
            sourceSets(it.sourceSets.main.get())
        }

        reports {
            xml.isEnabled = true
            xml.setDestination(file("${buildDir}/reports/jacoco/report.xml"))
            csv.isEnabled = false
            html.isEnabled = false
        }

        setDependsOn(listOf("test"))
    }
}
