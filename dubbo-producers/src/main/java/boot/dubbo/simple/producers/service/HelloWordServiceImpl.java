package boot.dubbo.simple.producers.service;

import boot.dubbo.simple.service.HelloWordService;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class HelloWordServiceImpl implements HelloWordService {


    @Override
    public String sayHello(String hello) {

        return "hello word dubbo :"+hello;
    }
}
