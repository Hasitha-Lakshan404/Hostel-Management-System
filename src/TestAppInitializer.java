import lk.D24.HostelManagement.dao.custom.EmployeeDAO;
import lk.D24.HostelManagement.dao.custom.impl.EmployeeDAOImpl;
import lk.D24.HostelManagement.entity.Employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/18/2022
 * Time :7:42 PM
 */

public class TestAppInitializer {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        EmployeeDAO employeeDAO=new EmployeeDAOImpl();

        ArrayList<Employee> all = employeeDAO.getAll();
        for (Employee employee : all) {
            System.out.println(employee);
        }


    }
}
