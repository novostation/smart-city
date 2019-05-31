package no.vo.servicegatewaynacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.webflux.ProxyExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceGatewayNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGatewayNacosApplication.class, args);
    }


    @RestController
    static class TestController {
        @RequestMapping("/test")
        public Mono<ResponseEntity<byte[]>> proxy(ProxyExchange<byte[]> proxy) throws Exception {
            //String url = "http://192.168.5.155:9000/alibaba-service-nacos-producer/user/list";
            String url = "https://spring.io/projects/spring-cloud";
            return proxy.uri(url).get();
        }

        @RequestMapping("/test1")
        public Mono<ResponseEntity<Object>> proxy1(ProxyExchange<Object> proxy) throws Exception {
            Mono<ResponseEntity<Object>> body = proxy.uri("http://192.168.5.155:9000/alibaba-service-nacos-producer/user/list").get();
            return body;
        }

    }


}
