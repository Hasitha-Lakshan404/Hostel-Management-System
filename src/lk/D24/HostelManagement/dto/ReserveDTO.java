package lk.D24.HostelManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/19/2022
 * Time :2:03 AM
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReserveDTO {
    String resId;
    LocalDate date;
    double keyMoney;
    String cusId;
    String roomId;
}
