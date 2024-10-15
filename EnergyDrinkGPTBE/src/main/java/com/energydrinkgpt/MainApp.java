package com.energydrinkgpt;

import com.energydrinkgpt.config.HibernateUtil;
import org.hibernate.Session;

public class MainApp {

    public static void main(String[] args) {
        // Empty main method for now
        // Start Hibernate session
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Session created");
        // Close session
        session.close();

        // Shutdown Hibernate
        HibernateUtil.shutdown();
    }
}
