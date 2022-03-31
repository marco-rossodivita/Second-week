package com.corso.java.esercizioDB;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LOG {

    public static final Logger L = Logger.getLogger(LOG.class);

    public static LOG instance = null;

    {BasicConfigurator.configure();}

    public LOG(){}

    /**
     * @return instance
     */
    public static LOG getInstance(){
        if(instance == null)
            synchronized (LOG.class){
                instance = new LOG();
            }

        return instance;
    }



}
