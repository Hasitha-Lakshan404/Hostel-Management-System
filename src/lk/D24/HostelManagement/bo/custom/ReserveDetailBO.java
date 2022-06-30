package lk.D24.HostelManagement.bo.custom;

import lk.D24.HostelManagement.dto.CustomDTO;
import lk.D24.HostelManagement.dto.ReserveDTO;
import lk.D24.HostelManagement.dto.RoomDTO;
import lk.D24.HostelManagement.dto.StudentDTO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : Hasitha Lakshan
 * Project Name: Hostel_Management_System
 * Date        : 6/30/2022
 * Time        : 8:58 PM
 */

public interface ReserveDetailBO {
    ArrayList<CustomDTO> getAllReservationDetails() throws IOException;
    public ArrayList<RoomDTO> getAllRoom() throws IOException;
    public ArrayList<StudentDTO> getAllStudent() throws IOException;
    boolean updateReservation(ReserveDTO dto) throws IOException;
}
