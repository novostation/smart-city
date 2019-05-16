package no.vo.serviceconsulproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceConsulProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsulProducerApplication.class, args);
    }

}
