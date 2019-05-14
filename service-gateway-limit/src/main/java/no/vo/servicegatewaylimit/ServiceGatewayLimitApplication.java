package no.vo.servicegatewaylimit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.util.Objects;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceGatewayLimitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGatewayLimitApplication.class, args);
    }

}
