package com.corso.java.jpa.domain;

import com.corso.java.utils.JPAUtils;
import org.apache.log4j.PropertyConfigurator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class JPATest {

    private static final String log4jProperties = "src/main/java/resources/log4j.properties";

    //ENtity manager si occupa di gestire tutte le transazioni verso il DB
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private EntityTransaction et;
    private Query query;

    public static void init(){
        PropertyConfigurator.configure(log4jProperties);
        emf = JPAUtils.getEntityManagerFactory();
        em = emf.createEntityManager();
    }


    public void createTransaction(){
        this.init();
        et = em.getTransaction();
        et.begin(); //inizia la transaction

        Family family;
        Person person;

        //Read the existing entries
        Query q = em.createQuery("select m from Person m");
        //Persons should be empty
    }

    public void print(){

    }

    public static void main(String[] args) {

        JPATest jpaTest = new JPATest();
        jpaTest.createTransaction();
    }

}
