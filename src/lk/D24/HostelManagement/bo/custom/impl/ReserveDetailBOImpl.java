package lk.D24.HostelManagement.bo.custom.impl;

import lk.D24.HostelManagement.bo.custom.ReserveDetailBO;
import lk.D24.HostelManagement.dao.custom.ReservationDAO;
import lk.D24.HostelManagement.dao.custom.RoomDAO;
import lk.D24.HostelManagement.dao.custom.impl.ReservationDAOImpl;
import lk.D24.HostelManagement.dao.custom.impl.RoomDAOImpl;
import lk.D24.HostelManagement.dto.CustomDTO;
import lk.D24.HostelManagement.dto.ReserveDTO;
import lk.D24.HostelManagement.dto.RoomDTO;
import lk.D24.HostelManagement.entity.CustomEntity;
import lk.D24.HostelManagement.entity.Reserve;
import lk.D24.HostelManagement.entity.Room;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/30/2022
 * Time :8:58 PM
 */

public class ReserveDetailBOImpl implements ReserveDetailBO {

    ReservationDAO reservationDAO = new ReservationDAOImpl();
    RoomDAO roomDAO=new RoomDAOImpl();

    @Override
    public ArrayList<CustomDTO> getAllReservationDetails() throws IOException {
        ArrayList<Reserve> all = reservationDAO.getAll();

        ArrayList<CustomDTO>arrayList=new ArrayList<>();


        for (Reserve res : all) {
            arrayList.add(new CustomDTO(
                    res.getStudent().getStudentId(),
                    res.getStudent().getName(),
                    res.getStudent().getAddress(),
                    res.getStudent().getTelNo(),
                    res.getStudent().getDob(),
                    res.getStudent().getGender(),
                    res.getResId(),
                    res.getDate(),
                    res.getStudent(),
                    res.getRoom(),
                    res.getStatus(),
                    res.getRoom().getRoomTypeId(),
                    res.getRoom().getType(),
                    res.getRoom().getKeyMoney(),
                    res.getRoom().getQty()
            ));


        }

        return arrayList;

    }

    @Override
    public ArrayList<RoomDTO> getAllRoom() throws IOException {
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

}
