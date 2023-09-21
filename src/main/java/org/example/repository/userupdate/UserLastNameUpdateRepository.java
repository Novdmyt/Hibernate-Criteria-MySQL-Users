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

public class UserLastNameUpdateRepository {
    public String updateLastName(User user) {

        if (IdChecker.isIdExists(user)) {
            return updateUserById(user);
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }

    private String updateUserById(User user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Транзакція стартує
            transaction = session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaUpdate<User> criteria = cb.createCriteriaUpdate(User.class);
            Root<User> root = criteria.from(User.class);
            criteria.set("lastName", user.getLastName());
            criteria.where(cb.equal(root.get("id"), user.getId()));
            session.createMutationQuery(criteria).executeUpdate();

            // Транзакція виконується
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