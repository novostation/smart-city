package no.vo.servicegatewayeureka;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixCommandController {

    @RequestMapping("/hystrixTimeout")
    public String hystrixTimeout() {
        return "i5xforyou-service-gateway触发了断路由";
    }

    @HystrixCommand(commandKey="authHystrixCommand")
    public String authHystrixCommand() {
        if (true) {
            System.out.println("111111111111111");
            throw new RuntimeException("没有没有对应的信息");
        }
        return "i5xforyou-service-gateway触发了断路由";
    }

    @RequestMapping("/timeout")
    public String timeout(){
        try{
            //睡5秒，网关Hystrix3秒超时
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "timeout";
    }

}
