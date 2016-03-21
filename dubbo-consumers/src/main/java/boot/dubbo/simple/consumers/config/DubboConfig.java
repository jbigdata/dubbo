package boot.dubbo.simple.consumers.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

/**
 * DubboConfig
 *
 * @author Jinkai.Ma
 */
@Configuration
@ComponentScan(basePackages = {"boot.dubbo.web"},
        includeFilters = {@ComponentScan.Filter(value = Service.class)})
public class DubboConfig {

    @Value("${dubbo.registry.address:zookeeper://127.0.0.1:2181}")
    private   String REGISTRY_ADDRESS ;

    @Value("${dubbo.application.name:dubbo-consumers}")
    private   String APPLICATION_NAME ;

    @Value("${dubbo.application.owner:wanliang}")
    private   String APPLICATION_OWNER ;

    @Value("${dubbo.protocol.port:20883}")
    private   Integer PROTOCOL_PORT;

    @Value("${dubbo.package.base:}")
    private static  String PACKAGE;

    @Bean
    public static AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("boot.dubbo.web");
        return annotationBean;
    }

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(APPLICATION_NAME);
        applicationConfig.setOwner(APPLICATION_OWNER);
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(REGISTRY_ADDRESS);
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig("dubbo");
        protocolConfig.setPort(PROTOCOL_PORT);
        return protocolConfig;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
