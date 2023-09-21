package org.example.repository.userupdate;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import org.example.entities.User;
import org.example.utils.Constants;
import org.example.utils.HibernateUtil;
import org.example.utils.IdChecker;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserEmailUpdateRepository {
    public String updateUser(User user) {

        if (IdChecker.isIdExists(user)) {
            return updateUserById(user);
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }

    private String updateUserById(User user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaUpdate<User> criteria = cb.createCriteriaUpdate(User.class);
            Root<User> root = criteria.from(User.class);
            criteria.set("email", user.getEmail());
            criteria.where(cb.equal(root.get("id"), user.getId()));
            session.createMutationQuery(criteria).executeUpdate();

            transaction.commit();
            return Constants.DATA_UPDATE_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}


