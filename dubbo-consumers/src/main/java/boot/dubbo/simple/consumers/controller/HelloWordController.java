package boot.dubbo.simple.consumers.controller;

import boot.dubbo.simple.service.HelloWordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;


@RestController
public class HelloWordController {
	
	@Reference
	private HelloWordService helloWordService;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello: " + helloWordService.sayHello("boot-dubbo");
	}

}
