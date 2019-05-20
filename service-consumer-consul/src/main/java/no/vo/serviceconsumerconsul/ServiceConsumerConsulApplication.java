package no.vo.serviceconsumerconsul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ServiceConsumerConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerConsulApplication.class, args);
    }



    //----------RestTemplate方式调用
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RestController
    static class TestController {

        @Autowired
        RestTemplate restTemplate;

        @GetMapping("/test")
        public String test() {
            String result = restTemplate.getForObject("http://service-provider-consul/user/list", String.class);
            return "Return : " + result;
        }
    }
    //----------RestTemplate方式调用



}
