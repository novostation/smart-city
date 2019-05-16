package no.vo.servicegatewaynacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceGatewayNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGatewayNacosApplication.class, args);
    }

}
