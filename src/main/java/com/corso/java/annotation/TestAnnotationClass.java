package com.corso.java.annotation;

import com.corso.java.utils.LOG;

@TestAnnotation


public class TestAnnotationClass {

    @SingleTestAnnotation(
            item = "Ciao",
            value = TestAnnotationEnum.SUCCESS)
    private String annotation;


    public static boolean isAnnotationPresent(){
        TestAnnotationClass test = new TestAnnotationClass();
        if(test.isAnnotationPresent())LOG.getInstance().debug("There is annotation!");
        else LOG.getInstance().debug("There is not an annotation");
        return false;
    }

    public static void main(String[] args) {
        TestAnnotationClass testAnnotationClass = new TestAnnotationClass();
        TestAnnotationClass.isAnnotationPresent();


    }
}
