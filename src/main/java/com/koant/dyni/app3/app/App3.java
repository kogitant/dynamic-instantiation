package com.koant.dyni.app3.app;

import com.koant.dyni.app3.page.ItemPage;

/**
 * Created by 616286 on 19.8.2014.
 */
public class App3 {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        ItemPage itemPage = new ItemPage();


        System.out.println("Calling item page with item from tailored customer");
        itemPage.execute("tailored");
        System.out.println("Calling item page with item from another customer");
        itemPage.execute("another");
        System.out.println("Calling item page with item from notfound customer");
        itemPage.execute("notfound");
        System.out.println("Calling item page with item from <blank> customer");
        itemPage.execute("");
        System.out.println("Calling item page with item from <null> customer");
        itemPage.execute(null);

    }
}

