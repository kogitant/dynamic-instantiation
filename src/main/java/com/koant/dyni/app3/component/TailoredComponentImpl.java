package com.koant.dyni.app3.component;

import com.koant.dyni.app3.annotation.CustomizedComponent;
import org.springframework.stereotype.Component;

/**
 * Created by 616286 on 19.8.2014.
 */
@Component
@CustomizedComponent(value = "tailored")
public class TailoredComponentImpl implements ComponentInterface {

    public void logSomething(){
        System.out.println("Tailored");
    }
}
