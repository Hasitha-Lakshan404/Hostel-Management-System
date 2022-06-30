package lk.D24.HostelManagement.view.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/30/2022
 * Time :8:53 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReserveDetailTM {
    String resId;
    LocalDate date;
    String studentId;
    String roomId;
    String status;
    String remainKeyMoney;


}
