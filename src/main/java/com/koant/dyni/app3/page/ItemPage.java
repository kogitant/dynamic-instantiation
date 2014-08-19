package com.koant.dyni.app3.page;

import com.koant.dyni.app3.component.ComponentFactory;

/**
 * Created by 616286 on 19.8.2014.
 */
public class ItemPage {

    //@SpringBean
    final ComponentFactory componentFactory;

    public ItemPage(){
        System.out.println("Initializing ItemPage");
        this.componentFactory = new ComponentFactory();
    }

    public void execute(String customization){
        this.componentFactory.initialize(customization).logSomething();
    }
}
