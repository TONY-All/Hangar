plugins {
    id ("java")
    id ("maven-publish")
    kotlin("jvm") version "1.4.31"
}

group = "me.minidigger"
version = "0.0.1-SNAPSHOT"
description = "hangar"

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator:2.4.4")
    implementation("org.springframework.boot:spring-boot-starter-jdbc:2.4.4")
    implementation("org.springframework.boot:spring-boot-starter-mail:2.4.4")
    implementation("org.springframework.boot:spring-boot-starter-security:2.4.4")
    implementation("org.springframework.boot:spring-boot-starter-web:2.4.4")
    implementation("org.springframework.boot:spring-boot-starter-undertow:2.4.4")
    implementation("org.springframework.boot:spring-boot-starter-cache:2.4.4")
    implementation("org.springframework.boot:spring-boot-starter-validation:2.4.4")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("javax.validation:validation-api:2.0.1.Final")
    implementation("org.yaml:snakeyaml:1.27")
    implementation("org.jdbi:jdbi3-core:3.19.0")
    implementation("org.jdbi:jdbi3-sqlobject:3.19.0")
    implementation("org.jdbi:jdbi3-postgres:3.19.0")
    implementation("org.jdbi:jdbi3-spring4:3.19.0")
    implementation("org.jdbi:jdbi3-stringtemplate4:3.19.0")
    implementation("org.postgresql:postgresql:42.2.19")
    implementation("org.flywaydb:flyway-core:7.1.1")
    implementation("com.vladsch.flexmark:flexmark-all:0.62.2")
    implementation("cz.jiripinkas:jsitemapgenerator:4.5")
    implementation("com.auth0:java-jwt:3.15.0")
    implementation("org.springframework.boot:spring-boot-configuration-processor:2.4.4")
    runtimeOnly("org.springframework.boot:spring-boot-devtools:2.4.4")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.4.4")
    testImplementation("org.springframework.security:spring-security-test:5.4.5")
}

tasks.withType(JavaCompile::class.java) {
    options.encoding = "UTF-8"
}