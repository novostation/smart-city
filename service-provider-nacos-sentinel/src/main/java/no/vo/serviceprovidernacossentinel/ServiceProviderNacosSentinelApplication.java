package no.vo.serviceprovidernacossentinel;

import no.vo.common.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class ServiceProviderNacosSentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderNacosSentinelApplication.class, args);
    }

    @RestController
    static class TestController {

        @GetMapping(value = "/user/list")
        //@SentinelResource("hello")  //注解用来标识资源是否被限流、降级。上述例子上该注解的属性 'hello' 表示资源名。
        public String hello(HttpServletRequest request) {
            return "服务提供者nacos-sentinel:"+request.getServerPort()+"  "+request.getLocalPort()+" <br>"+ User.list();
        }

    }

}
