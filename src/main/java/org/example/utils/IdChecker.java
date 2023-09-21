package org.example.utils;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.example.entities.User;
import org.hibernate.Session;

public class IdChecker {
    public static boolean isIdExists(User user) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Перевірка наявності об'єкту за певним id
            user = session.get(User.class, user.getId());

            if (user != null) {
                CriteriaBuilder builder = session.getCriteriaBuilder();
                CriteriaQuery<User> criteria = builder.createQuery(User.class);
                criteria.from(User.class);
                session.createQuery(criteria).setMaxResults(1);
            }
            return user!= null;
        }
    }
}