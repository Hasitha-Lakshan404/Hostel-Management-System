package lk.D24.HostelManagement.dao.custom;

import lk.D24.HostelManagement.dao.CrudDAO;
import lk.D24.HostelManagement.dto.RoomDTO;
import lk.D24.HostelManagement.entity.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hasitha Lakshan
 * Project Name: Hostel_Management_System
 * Date        : 6/17/2022
 * Time        : 4:57 PM
 */

public interface RoomDAO extends CrudDAO<Room,String> {
    public List<Room> getRoomDataFromType(String type) throws IOException;
}
