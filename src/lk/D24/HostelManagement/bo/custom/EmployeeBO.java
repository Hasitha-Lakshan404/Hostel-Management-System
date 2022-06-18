package lk.D24.HostelManagement.bo.custom;

import lk.D24.HostelManagement.bo.custom.SuperBO;
import lk.D24.HostelManagement.dto.EmployeeDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Hasitha Lakshan
 * Project Name: Hostel_Management_System
 * Date        : 6/17/2022
 * Time        : 10:28 PM
 */

public interface EmployeeBO extends SuperBO {
    ArrayList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException, IOException;

    boolean saveEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;

    boolean existEmployee(String id) throws SQLException, ClassNotFoundException;

    boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;

    String generateEmployeeId() throws SQLException, ClassNotFoundException;
}
