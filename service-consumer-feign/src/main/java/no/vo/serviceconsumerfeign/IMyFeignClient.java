package no.vo.serviceconsumerfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="user-server")
public interface IMyFeignClient {

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list();

}
