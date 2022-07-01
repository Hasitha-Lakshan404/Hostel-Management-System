package lk.D24.HostelManagement.dao.custom.impl;

import lk.D24.HostelManagement.dao.custom.UserDAO;
import lk.D24.HostelManagement.entity.Room;
import lk.D24.HostelManagement.entity.User;
import lk.D24.HostelManagement.util.FactoryConfiguration;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :7/1/2022
 * Time :3:46 PM
 */

public class UserDAOImpl implements UserDAO {

    @Override
    public ArrayList<User> getAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);
        List user = criteria.list();

        ArrayList<User> all = new ArrayList<>(user);

        transaction.commit();
        session.close();
        return all;
    }

    @Override
    public boolean save(User entity) throws IOException {
        return false;
    }

    @Override
    public boolean update(User entity) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws IOException {
        return false;
    }

    @Override
    public String generateNewID() throws IOException {
        return null;
    }

    @Override
    public User search(String id) {
        return null;
    }
}
