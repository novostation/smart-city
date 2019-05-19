package no.vo.serviceprovidereureka;

import no.vo.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String list(HttpServletRequest request) {
        try{
            Thread.sleep(3000);
        }catch (Exception e){ e.printStackTrace();
        }
        if(true){
            throw new RuntimeException("没有没有对应的信息");
        }
        return "服务提供者service-provider-eureka:"+request.getServerPort()+"  "+request.getLocalPort()+" <br>"+User.list();
    }


    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("**********" + list);
        List<ServiceInstance> srvList = client.getInstances("user-server");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }

}
