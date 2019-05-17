package no.vo.servicegatewayeurekalimit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceGatewayEurekaLimitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGatewayEurekaLimitApplication.class, args);
    }

    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }

}
