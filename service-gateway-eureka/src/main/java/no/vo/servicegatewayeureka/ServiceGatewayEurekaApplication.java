package no.vo.servicegatewayeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceGatewayEurekaApplication {

    @RequestMapping("/hystrixfallback")
    public String hystrixfallback() {
        return "This is a fallback";
    }


    /*@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("hystrix_route", r -> r.path("/**")
                        .filters(f -> f.hystrix(c -> c.setName("authHystrixCommand")))
                        .uri("lb://USER-SERVER"))
                .route("hystrix_fallback_route", r -> r.path("/**")
                        .filters(f -> f.hystrix(c -> c.setName("authHystrixCommand").setFallbackUri("forward:/hystrixfallback")))
                        .uri("localhost:9001"))
                .build();
    }*/


    public static void main(String[] args) {
        SpringApplication.run(ServiceGatewayEurekaApplication.class, args);
    }

}
