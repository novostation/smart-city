package no.vo.servicecunsumerfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="producer-server")
public interface IMyFeignClient {

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list();

}
