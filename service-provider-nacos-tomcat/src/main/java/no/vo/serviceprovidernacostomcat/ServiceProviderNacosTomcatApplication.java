package no.vo.serviceprovidernacostomcat;

import no.vo.common.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@SpringBootApplication
public class ServiceProviderNacosTomcatApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ServiceProviderNacosTomcatApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderNacosTomcatApplication.class, args);
    }

   @RestController
    static class TestController {
        @GetMapping("/user/list")
        public String list(HttpServletRequest request) {
            return "服务提供者nacos:"+request.getServerPort()+"  "+request.getLocalPort()+" <br>"+ User.list();
        }
    }


}
