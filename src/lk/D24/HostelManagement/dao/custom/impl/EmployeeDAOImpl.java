package lk.D24.HostelManagement.dao.custom.impl;


import lk.D24.HostelManagement.dao.custom.EmployeeDAO;
import lk.D24.HostelManagement.entity.Employee;
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
 * Time :5:14 PM
 */

public class EmployeeDAOImpl implements EmployeeDAO {
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
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException, IOException {

       /* Employee emp1 = new Employee("Emp-001", "Hasitha", "0776813566");
        Employee emp2 = new Employee("Emp-002", "Lakshan", "051879526");
        Employee emp3 = new Employee("Emp-003", "Nelson", "1558749952");

        session.save( emp1);
        session.save(emp2);
        session.save(emp3);*/

        Criteria criteria = session.createCriteria(Employee.class);
        List employees = criteria.list();

        ArrayList<Employee> empAll = new ArrayList<>(employees);

        transaction.commit();
        session.close();
        return empAll;
    }

    @Override
    public boolean save(Employee dto) throws SQLException, ClassNotFoundException {

        return false;
    }

    @Override
    public boolean update(Employee dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Employee search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
