package org.example.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.entities.User;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class UserReadRepository {
    public List<User> readContacts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction;

            transaction = session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> cr = cb.createQuery(User.class);
            Root<User> root = cr.from(User.class);
            cr.select(root);
            Query<User> query = session.createQuery(cr);
            List<User> contacts = query.getResultList();
            transaction.commit();
            return contacts;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
