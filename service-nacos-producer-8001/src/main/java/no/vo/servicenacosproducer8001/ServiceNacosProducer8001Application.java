package no.vo.servicenacosproducer8001;

import no.vo.common.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceNacosProducer8001Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceNacosProducer8001Application.class, args);
    }

    @RestController
    static class TestController {
        @GetMapping("/list")
        public String list(@RequestParam String name) {
            return name + "<br> service-nacos-producer-8001 <br>" + User.list();
        }
    }

}
