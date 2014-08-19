package com.koant.dyni.app3.component;

import com.koant.dyni.app3.annotation.CustomizedComponent;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 616286 on 19.8.2014.
 */
public class ComponentFactory {
    private final Map<String,Class> componentImplementations;

    public ComponentFactory() {
        System.out.println("ComponentFactory");
        componentImplementations = new HashMap<String, Class>();
        try {
        // Find all classes from classpath that have desired annotation
        // The annotation is a custom one, potentially such an annotation would be defined for all components that will be customized
        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(CustomizedComponent.class));

        java.util.Set<BeanDefinition> candidates = scanner.findCandidateComponents("com.koant.dyni.app3.component");
        for (BeanDefinition bd : candidates) {
            System.out.println("Considering candidate implementation calss " + bd.getBeanClassName());

            // Get the class object based on the name (string) of the class
            Class c = Class.forName(bd.getBeanClassName());

            // Get the annotation value from the class
            // The annotation would ahve a customer specific value, here it's "tailored"
            // @CustomizedComponent(value = "tailored")
            CustomizedComponent annotation = (CustomizedComponent) c.getAnnotation(CustomizedComponent.class);
            System.out.println("The component is customized for customer  = " + annotation);

            componentImplementations.put(annotation.value(), c);

        }
        }catch(Exception e){
            throw new IllegalStateException("Can't do my thing. This bad.", e);
        }

        System.out.println("ComponentFactory initialized, found " + componentImplementations.size() + " component implementations in classpath");

    }
    public ComponentInterface initialize(String customization) {
        Class c = componentImplementations.get(customization);
        if(c==null){
            c = CommonComponentImpl.class;
        }
        try {
            return (ComponentInterface)c.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("This bad", e);
        }
    }
}
