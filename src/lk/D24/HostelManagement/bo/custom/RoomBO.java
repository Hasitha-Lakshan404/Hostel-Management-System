package lk.D24.HostelManagement.bo.custom;

import lk.D24.HostelManagement.dto.RoomDTO;
import lk.D24.HostelManagement.dto.StudentDTO;
import lk.D24.HostelManagement.entity.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hasitha Lakshan
 * Project Name: Hostel_Management_System
 * Date        : 6/19/2022
 * Time        : 1:30 PM
 */

public interface RoomBO {
    ArrayList<RoomDTO> getAllRoom() throws IOException;

    boolean saveRoom(RoomDTO dto) throws IOException;

    boolean updateRoom(RoomDTO dto) throws IOException;

    boolean deleteRoom(String id) throws IOException;

    String generateRoomId();

    public List<Room> getRoomDataFromType(String type) throws IOException;

    public Room getRoom(String id) throws IOException;
}
