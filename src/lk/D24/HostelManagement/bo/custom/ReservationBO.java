package lk.D24.HostelManagement.bo.custom;

import lk.D24.HostelManagement.dto.RoomDTO;
import lk.D24.HostelManagement.dto.StudentDTO;
import lk.D24.HostelManagement.entity.Room;
import lk.D24.HostelManagement.entity.Student;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : Hasitha Lakshan
 * Project Name: Hostel_Management_System
 * Date        : 6/29/2022
 * Time        : 1:46 AM
 */

public interface ReservationBO {
    public Room getRoom(String id) throws IOException ;

    public Student getStudent(String id) throws IOException;

    ArrayList<StudentDTO> getAllStudent() throws IOException;

    ArrayList<RoomDTO> getAllRoom() throws IOException;


}
