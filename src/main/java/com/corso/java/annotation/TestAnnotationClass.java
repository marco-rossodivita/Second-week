package com.corso.java.annotation;


import com.corso.java.utils.LOG;



@TestAnnotation
@SingleTestAnnotation(
        item = "Ciao")
public class TestAnnotationClass {

    private String annotation;


    public static boolean isAnnotationPresents(){

        Class test = TestAnnotationClass.class;
        if(test.isAnnotationPresent(TestAnnotationClass.class)) LOG.getInstance().debug("There is annotation!!!!!");
        else LOG.getInstance().debug("There is not a annotation!!!!!");
        return false;
    }

    public static void main(String[] args) {}
}
