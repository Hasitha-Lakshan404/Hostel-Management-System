package lk.D24.HostelManagement.dao.custom;

import lk.D24.HostelManagement.dao.CrudDAO;
import lk.D24.HostelManagement.entity.Student;

import java.io.IOException;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/17/2022
 * Time :4:53 PM
 */

public interface StudentDAO extends CrudDAO<Student,String> {
    public Student getStudent(String id) throws IOException;
}
