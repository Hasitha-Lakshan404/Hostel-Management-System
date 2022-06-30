package lk.D24.HostelManagement.bo.custom.impl;

import lk.D24.HostelManagement.bo.custom.ReservationBO;
import lk.D24.HostelManagement.dao.custom.ReservationDAO;
import lk.D24.HostelManagement.dao.custom.RoomDAO;
import lk.D24.HostelManagement.dao.custom.StudentDAO;
import lk.D24.HostelManagement.dao.custom.impl.ReservationDAOImpl;
import lk.D24.HostelManagement.dao.custom.impl.RoomDAOImpl;
import lk.D24.HostelManagement.dao.custom.impl.StudentDAOImpl;
import lk.D24.HostelManagement.dto.ReserveDTO;
import lk.D24.HostelManagement.dto.RoomDTO;
import lk.D24.HostelManagement.dto.StudentDTO;
import lk.D24.HostelManagement.entity.Reserve;
import lk.D24.HostelManagement.entity.Room;
import lk.D24.HostelManagement.entity.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/29/2022
 * Time :1:45 AM
 */


public class ReservationBOImpl implements ReservationBO {
    RoomDAO roomDAO = new RoomDAOImpl();
    StudentDAO studentDAO = new StudentDAOImpl();
    ReservationDAO reservationDAO = new ReservationDAOImpl();

    @Override
    public Room getRoom(String id) throws IOException {
        return roomDAO.getRoom(id);
    }

    @Override
    public Student getStudent(String id) throws IOException {
        return studentDAO.getStudent(id);
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() throws IOException {
        ArrayList<Student> all = studentDAO.getAll();

        ArrayList<StudentDTO> allStudent = new ArrayList<>();

        for (Student student : all) {
            allStudent.add(new StudentDTO(
                    student.getStudentId(),
                    student.getName(),
                    student.getAddress(),
                    student.getTelNo(),
                    student.getDob(),
                    student.getGender()
            ));
        }

        return allStudent;
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


    @Override
    public List<ReserveDTO> searchReservedRoomById(String id) throws IOException {
        List<Reserve> reserves = reservationDAO.searchReservedRoomById(id);

        List<ReserveDTO> reserveDTOS = new ArrayList<>();

        for (Reserve reserve : reserves) {
            reserveDTOS.add(new ReserveDTO(
                    reserve.getResId(),
                    reserve.getDate(),
                    reserve.getStudent(),
                    reserve.getRoom(),
                    reserve.getStatus()
            ));

        }
        return reserveDTOS;
    }

    @Override
    public boolean registerStudent(ReserveDTO dto) throws IOException {
        return reservationDAO.save(new Reserve(
                dto.getResId(),
                dto.getDate(),
                dto.getStudentId(),
                dto.getRoomId(),
                dto.getStatus()
        ));
    }

}
