package no.vo.serviceprovidernacos;

import no.vo.common.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProviderNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderNacosApplication.class, args);
    }

    @RestController
    static class TestController {
        @GetMapping("/user/list")
        public String list(HttpServletRequest request) {
            return "服务提供者nacos:"+request.getServerPort()+"  "+request.getLocalPort()+" <br>"+ User.list();
        }
    }

}
