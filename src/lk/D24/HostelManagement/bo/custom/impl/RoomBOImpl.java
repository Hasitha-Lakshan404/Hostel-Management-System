package lk.D24.HostelManagement.bo.custom.impl;

import lk.D24.HostelManagement.bo.custom.RoomBO;
import lk.D24.HostelManagement.dao.custom.RoomDAO;
import lk.D24.HostelManagement.dao.custom.impl.RoomDAOImpl;
import lk.D24.HostelManagement.dto.RoomDTO;
import lk.D24.HostelManagement.dto.StudentDTO;
import lk.D24.HostelManagement.entity.Room;
import lk.D24.HostelManagement.entity.Student;

import java.util.ArrayList;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/19/2022
 * Time :1:30 PM
 */

public class RoomBOImpl implements RoomBO {
    RoomDAO roomDAO=new RoomDAOImpl();

    @Override
    public ArrayList<RoomDTO> getAllRoom() {
        ArrayList<Room> all = roomDAO.getAll();

        ArrayList<RoomDTO> allRoom = new ArrayList<>();

        for (Room room : all) {
            allRoom.add(new RoomDTO(
                    room.getRoomTypeId(),
                    room.getType(),
                    room.getKeyMoney(),
                    room.getQty()

            ));
        }

        return allRoom;
    }

    @Override
    public boolean saveRoom(RoomDTO dto) {
        return roomDAO.save(new Room(
                dto.getRoomTypeId(),
                dto.getType(),
                dto.getKeyMoney(),
                dto.getQty()
        ));
    }

    @Override
    public boolean updateRoom(RoomDTO dto) {
        return roomDAO.update(new Room(
                dto.getRoomTypeId(),
                dto.getType(),
                dto.getKeyMoney(),
                dto.getQty()
        ));
    }

    @Override
    public boolean deleteRoom(String id) {
        return roomDAO.delete(id);
    }

    @Override
    public String generateRoomId() {
        return null;
    }
}
