package no.vo.servicegatewway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceGatewwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGatewwayApplication.class, args);
    }

}
