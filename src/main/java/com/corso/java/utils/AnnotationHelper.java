package com.corso.java.utils;

import com.corso.java.annotation.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationHelper<A extends Annotation> {

    public static void getAnnotation() {
        for (Method f : AnnotationHelper.class.getDeclaredMethods()) {
            Logger logger = f.getAnnotation(Logger.class);
            if (logger != null)
                LOG.getInstance().info(logger.item());
        }
    }
}
