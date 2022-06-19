package lk.D24.HostelManagement.bo.custom;

import lk.D24.HostelManagement.dto.RoomDTO;
import lk.D24.HostelManagement.dto.StudentDTO;

import java.util.ArrayList;

/**
 * @author : Hasitha Lakshan
 * Project Name: Hostel_Management_System
 * Date        : 6/19/2022
 * Time        : 1:30 PM
 */

public interface RoomBO {
    ArrayList<RoomDTO> getAllRoom();

    boolean saveRoom(RoomDTO dto);

    boolean updateRoom(RoomDTO dto);

    boolean deleteRoom(String id);

    String generateRoomId();
}
