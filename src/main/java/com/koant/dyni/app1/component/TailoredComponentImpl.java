package com.koant.dyni.app1.component;

import org.springframework.stereotype.Component;

/**
 * Created by 616286 on 19.8.2014.
 */
@Component
public class TailoredComponentImpl implements ComponentInterface {

    public void logSomething(){
        System.out.println("Tailored");
    }
}
