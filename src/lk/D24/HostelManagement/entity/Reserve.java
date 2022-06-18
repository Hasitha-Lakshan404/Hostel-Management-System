package lk.D24.HostelManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/18/2022
 * Time :11:48 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reserve {
    String resId;
    LocalDate date;
    double keyMoney;
    String cusId;
    String roomId;
}
