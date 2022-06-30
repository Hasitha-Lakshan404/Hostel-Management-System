package lk.D24.HostelManagement.dao.custom;

import lk.D24.HostelManagement.dao.CrudDAO;
import lk.D24.HostelManagement.entity.Reserve;

import java.io.IOException;
import java.util.List;

/**
 * @author : Hasitha Lakshan
 * Project Name: Hostel_Management_System
 * Date        : 6/29/2022
 * Time        : 1:47 AM
 */

public interface ReservationDAO extends CrudDAO<Reserve, String> {
    List<Reserve> searchReservedRoomById(String id) throws IOException;
}
