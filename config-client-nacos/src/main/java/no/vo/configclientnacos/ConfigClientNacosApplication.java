package no.vo.configclientnacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientNacosApplication.class, args);
    }


    @RestController
    @RefreshScope  //配置内容支持动态刷新
    static class TestController {

        @Value("${didispace.title:}")
        private String title;

        @GetMapping("/test")
        public String hello() {
            if(title!=null&&title.trim().length()>0){
                System.out.println("-----------------------------------------"+title);
            }
            return title;
        }

    }


}
