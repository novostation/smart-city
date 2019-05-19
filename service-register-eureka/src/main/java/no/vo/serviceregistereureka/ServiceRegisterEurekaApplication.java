package no.vo.serviceregistereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // EurekaServer服务器端启动类,接受其它微服务注册进来
@SpringBootApplication
public class ServiceRegisterEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegisterEurekaApplication.class, args);
    }

}
