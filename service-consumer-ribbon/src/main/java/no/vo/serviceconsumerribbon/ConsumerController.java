package no.vo.serviceconsumerribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController
{

	private static final String REST_URL_PREFIX = "http://PRODUCER-SERVER";

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/consumer/list")
	public Object add()
	{
		return restTemplate.getForEntity(REST_URL_PREFIX +"/list", String.class).getBody();
	}


	// 测试@EnableDiscoveryClient,消费端可以调用服务发现
	@RequestMapping(value = "/consumer/dept/discovery")
	public Object discovery()
	{
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
	}

}
