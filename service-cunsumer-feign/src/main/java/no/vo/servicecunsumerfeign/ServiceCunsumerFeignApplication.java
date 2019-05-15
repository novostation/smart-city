package no.vo.servicecunsumerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ServiceCunsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCunsumerFeignApplication.class, args);
    }

}
