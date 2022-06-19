package lk.D24.HostelManagement.bo.custom;

import lk.D24.HostelManagement.dto.StudentDTO;

import java.util.ArrayList;

/**
 * @author : Hasitha Lakshan
 * Project Name: Hostel_Management_System
 * Date        : 6/19/2022
 * Time        : 2:31 AM
 */

public interface StudentBO {

    ArrayList<StudentDTO> getAllStudent();

    boolean saveStudent(StudentDTO dto);

    boolean updateStudent(StudentDTO dto);

    boolean deleteStudent(String id);

    String generateStudentId();
}
