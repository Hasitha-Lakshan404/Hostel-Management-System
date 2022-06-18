package lk.D24.HostelManagement.bo.custom.impl;

import lk.D24.HostelManagement.bo.custom.EmployeeBO;
import lk.D24.HostelManagement.dao.custom.EmployeeDAO;
import lk.D24.HostelManagement.dao.custom.impl.EmployeeDAOImpl;
import lk.D24.HostelManagement.dto.EmployeeDTO;
import lk.D24.HostelManagement.entity.Employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/17/2022
 * Time :10:28 PM
 */

public class EmployeeBOImpl implements EmployeeBO {



    @Override
    public ArrayList<EmployeeDTO> getAllEmployee() throws SQLException, IOException, ClassNotFoundException {
        EmployeeDAO employeeDAO=new EmployeeDAOImpl();

        ArrayList<EmployeeDTO> employeeDTOS=new ArrayList<>();

        for (Employee employee : employeeDAO.getAll()) {
//            employeeDTOS.add(new EmployeeDTO(employee));
        }

        return null;
    }

    @Override
    public boolean saveEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existEmployee(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateEmployeeId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
