package org.example.repository;

import org.example.entities.User;
import org.example.utils.Constants;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserCreateRepository {
    public String createContact(User user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(user);

          
            transaction.commit();
            return Constants.DATA_INSERT_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}