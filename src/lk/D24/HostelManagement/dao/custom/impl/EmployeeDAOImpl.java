package lk.D24.HostelManagement.dao.custom.impl;

import lk.D24.HostelManagement.dao.custom.EmployeeDAO;
import lk.D24.HostelManagement.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/17/2022
 * Time :5:14 PM
 */

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        return null;
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
