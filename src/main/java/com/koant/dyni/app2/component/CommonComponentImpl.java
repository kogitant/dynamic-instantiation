package com.koant.dyni.app2.component;

import org.springframework.stereotype.Component;

/**
 * Created by 616286 on 19.8.2014.
 */
@Component
public class CommonComponentImpl implements ComponentInterface{

    public void logSomething(){
        System.out.println("Common");
    }

}
