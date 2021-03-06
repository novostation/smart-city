package no.vo.serviceproviderhystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController
{

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "addServiceFallback") //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	/*@HystrixCommand(
			fallbackMethod = "addServiceFallback",
			commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
	}) //代码中修改默认超时配置（改为3秒）*/
	public String listUserMethod()
	{

		if (true) {
			System.out.println("111111111111111");
			throw new RuntimeException("没有没有对应的信息");
		}
		
		return "SUCCESS";
	}

	public String addServiceFallback()
	{
		return "ERROR" ;
	}
}