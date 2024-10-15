package com.energydrinkgpt.config;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionUtil {

    public static <T> T executeWithTransaction(TransactionalOperation<T> operation) {
        Transaction transaction = null;
        T result = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Perform the operation and get the result
            result = operation.execute(session);

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return result;
    }
}
