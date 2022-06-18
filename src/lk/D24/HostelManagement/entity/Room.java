package lk.D24.HostelManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/17/2022
 * Time :4:25 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {
    String roomId;
    String type;
    double monthly_rent;
    String qty;
}
