package no.vo.serviceproviderconsul;

import no.vo.common.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@EnableDiscoveryClient  //此注解为consul注册配置
@SpringBootApplication
public class ServiceProviderConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderConsulApplication.class, args);
    }

    @RestController
    static class TestController {
        @GetMapping("/user/list")
        public String list(HttpServletRequest request) {
            return "服务提供者Consul:"+request.getServerPort()+"  "+request.getLocalPort()+" <br>"+ User.list();
        }
    }

}
