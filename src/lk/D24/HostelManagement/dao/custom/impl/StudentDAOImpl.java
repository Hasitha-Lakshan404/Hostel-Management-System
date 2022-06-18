package lk.D24.HostelManagement.dao.custom.impl;

import lk.D24.HostelManagement.dao.CrudDAO;
import lk.D24.HostelManagement.dao.custom.StudentDAO;
import lk.D24.HostelManagement.entity.Room;
import lk.D24.HostelManagement.entity.Student;
import lk.D24.HostelManagement.util.FactoryConfiguration;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/17/2022
 * Time :4:51 PM
 */

public class StudentDAOImpl implements StudentDAO {
    Session session;

    {
        try {
            session = FactoryConfiguration.getInstance().getSession();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    Transaction transaction=session.beginTransaction();

    @Override
    public ArrayList<Student> getAll() {
        Criteria criteria = session.createCriteria(Student.class);
        List student = criteria.list();

        ArrayList<Student> allSt = new ArrayList<>(student);

        transaction.commit();
        session.close();
        return allSt;    }

    @Override
    public boolean save(Student entity) {
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student entity) {
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }


    @Override
    public boolean delete(String s) {
        Student load = session.load(Student.class, s);
        session.delete(load);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public String generateNewID() {
        return null;
    }

    @Override
    public Student search(String id) {
        return null;
    }
}
