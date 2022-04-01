package com.corso.java.hibernate;

import com.corso.java.utils.LOG;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateRunner {

    LOG L = LOG.getInstance();
    Transaction transaction=null;

    public static void main(String[] args) {
        HibernateRunner hibernateRunner = new HibernateRunner();
        hibernateRunner.run();
    }

    public void run(){
        SessionFactory sessionFactory = null;
        Session session = null;

        //legge i file di configurazione di hibernate, già pronto
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); //questo è un file di Hibernate

        //il ServiceRegistry va a registrare i servizi; utilizza il session factory per utilizzare tutte le connessioni
        StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());

        //recuperiamo la sessione
        sessionFactory = configuration.buildSessionFactory(serviceRegistry.build());
        session = sessionFactory.openSession();
        persistPerson(session);


    }


    //Dobbiamo far persistere una persona, per cui creiamo il metodo
    public void persistPerson(Session session){

        try{

            transaction = session.getTransaction();
            transaction.begin(); //inizia la transazione

            Person person = new Person();
            person.setFirstName("Marco");
            person.setLastName("Rossodivita");

            session.save(person);
            transaction.commit();


        }catch (Exception e){
            if(session.getTransaction().isActive())
                session.getTransaction().rollback();
            L.err(e.getMessage());
        }
    }
}

/**
 * Sessione aperta
 * Transazione aperta
 * Transazione inizializzata
 */