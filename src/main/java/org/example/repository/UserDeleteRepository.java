package org.example.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;
import org.example.entities.User;
import org.example.utils.Constants;
import org.example.utils.HibernateUtil;
import org.example.utils.IdChecker;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDeleteRepository {
    public String deleteContact(User user) {

        if (IdChecker.isIdExists(user)) {
            return deleteContactById(user);
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }

    public String deleteContactById(User user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

                       user = session.get(User.class, user.getId());

            if (user != null) {
                CriteriaBuilder cb = session.getCriteriaBuilder();
                CriteriaDelete<User> criteria = cb.createCriteriaDelete(User.class);
                Root<User> root = criteria.from(User.class);
                criteria.where(cb.equal(root.get("id"), user.getId()));
                session.createMutationQuery(criteria).executeUpdate();
            }

            transaction.commit();
            return Constants.DATA_DELETE_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}