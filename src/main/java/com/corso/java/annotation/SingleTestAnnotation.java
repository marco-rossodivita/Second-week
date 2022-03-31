package com.corso.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({
        ElementType.TYPE,
        ElementType.METHOD,
        ElementType.FIELD})
public @interface SingleTestAnnotation {

    String item();
}
