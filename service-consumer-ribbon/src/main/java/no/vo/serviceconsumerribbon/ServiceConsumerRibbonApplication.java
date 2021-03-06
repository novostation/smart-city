package no.vo.serviceconsumerribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient //通过@EnableDiscoveryClient注解来添加发现服务能力
@SpringBootApplication
public class ServiceConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerRibbonApplication.class, args);
    }

}
