package lk.D24.HostelManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/19/2022
 * Time :2:02 AM
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    String roomId;
    String type;
    double monthly_rent;
    String qty;
}
