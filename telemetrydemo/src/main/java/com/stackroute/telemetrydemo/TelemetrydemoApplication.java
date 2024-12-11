package com.stackroute.telemetrydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelemetrydemoApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TelemetrydemoApplication.class);

//		SpringApplication.run(TelemetrydemoApplication.class, args);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}

/*
java -javaagent:/home/ubuntu/Desktop/opentelemetry-javaagent.jar  \
     -Dotel.traces.exporter=logging \
     -Dotel.metrics.exporter=logging \
     -Dotel.resource.attributes=service.name=telemetry \
     -Dotel.metrics.exporter.console.interval=1s \
     -Dotel.logging.level=debug \
     -jar telemetrydemo-0.0.1-SNAPSHOT.jar

//mvn clean install -DskipTests
//https://opentelemetry.io/docs/languages/java/getting-started/

 */