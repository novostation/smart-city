package no.vo.serviceconsumerfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController  {

    @Autowired
    private IMyFeignClient myFeignClient;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list() {
        return myFeignClient.list();
    }

}
