package com.koant.dyni.app1.app;

import com.koant.dyni.app2.component.AnotherComponentImpl;
import com.koant.dyni.app2.component.CommonComponentImpl;
import com.koant.dyni.app2.component.ComponentInterface;
import com.koant.dyni.app2.component.TailoredComponentImpl;

/**
 * Created by 616286 on 19.8.2014.
 */
public class App1 {

    public static void main(String[] args){
        System.out.println("Main!");

        Class<? extends ComponentInterface> c = null;
        ComponentInterface impl = null;
        try {
            c = TailoredComponentImpl.class;
            impl = c.newInstance();
            impl.logSomething();

            c = CommonComponentImpl.class;
            impl = c.newInstance();
            impl.logSomething();

            c = AnotherComponentImpl.class;
            impl = c.newInstance();
            impl.logSomething();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
