package com.koant.dyni.app2.app;

import com.koant.dyni.app2.annotation.CustomizedComponent;
import com.koant.dyni.app2.component.CommonComponentImpl;
import com.koant.dyni.app2.component.ComponentInterface;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * Created by 616286 on 19.8.2014.
 */
public class App2 {

    private static String custmizationName = "another";

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        System.out.println("Main!");

        Class c = null;
        ComponentInterface impl = null;


        // Find all classes from classpath that have desired annotation
        // The annotation is a custom one, potentially such an annotation would be defined for all components that will be customized
        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(true);
        scanner.addIncludeFilter(new AnnotationTypeFilter(CustomizedComponent.class));

        java.util.Set<org.springframework.beans.factory.config.BeanDefinition> candidates = scanner.findCandidateComponents("com.koant.dyni.app2.component");
        for (BeanDefinition bd : candidates){
            System.out.println("Considering candidate implementation calss " + bd.getBeanClassName());

            // Get the class object based on the name (string) of the class
            c = Class.forName(bd.getBeanClassName());

            // Get the annotation value from the class
            // The annotation would ahve a customer specific value, here it's "tailored"
            // @CustomizedComponent(value = "tailored")
            CustomizedComponent annotation = (CustomizedComponent)c.getAnnotation(CustomizedComponent.class);
            System.out.println("The component is customized for customer  = " + annotation.value());

            // Check if the class is the one we want
            if(annotation.value().equals(custmizationName)){
                // It is, let's break out
                break;
            }else{
                // The component was not the one we wanted
                c = null;
            }
        }

        // If a customized implementation has not been found use the common one
        if(c==null){
            c = CommonComponentImpl.class;
        }

        // Instantiate the component
        impl = (ComponentInterface)c.newInstance();


        // Do something with the component
        impl.logSomething();
    }
}
