package org.nick.kinderremote.util.state;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

//@Component
@Configuration
public class ServiceMapper {
    @PostConstruct
    private void createString(){
        new StartState();
        System.out.println("====================SERVICEMAPPER+++++++++");
        System.out.println(StartState.initString+"Appended");
    }
}
