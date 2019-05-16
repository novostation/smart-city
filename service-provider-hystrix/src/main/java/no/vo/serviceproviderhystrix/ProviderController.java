package no.vo.serviceproviderhystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController
{

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "addServiceFallback") //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	public String get()
	{

		if (true) {
			throw new RuntimeException("没有没有对应的信息");
		}
		
		return "";
	}

	public String addServiceFallback()
	{
		return "error" ;
	}
}