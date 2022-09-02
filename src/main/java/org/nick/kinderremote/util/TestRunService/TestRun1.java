package org.nick.kinderremote.util.TestRunService;

import org.nick.kinderremote.util.components.ServiceActor;
import org.springframework.stereotype.Service;

@Service
public class TestRun1 {

    private final ServiceActor servAct;


    public TestRun1(ServiceActor servAct) {
        this.servAct = servAct;

//        Method[] actors=ServiceActor.class.getDeclaredMethods();
//        for (Method actor : actors) {
//            actor.);
//        }


    }
}
