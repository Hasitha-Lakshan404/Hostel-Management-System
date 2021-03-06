package lk.D24.HostelManagement.bo.custom;

import lk.D24.HostelManagement.dto.StudentDTO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : Hasitha Lakshan
 * Project Name: Hostel_Management_System
 * Date        : 6/19/2022
 * Time        : 2:31 AM
 */

public interface StudentBO {

    ArrayList<StudentDTO> getAllStudent() throws IOException;

    boolean saveStudent(StudentDTO dto) throws IOException;

    boolean updateStudent(StudentDTO dto) throws IOException;

    boolean deleteStudent(String id) throws IOException;



    String generateStudentId();
}
