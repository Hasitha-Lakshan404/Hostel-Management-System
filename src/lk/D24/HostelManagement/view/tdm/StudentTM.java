package lk.D24.HostelManagement.view.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/25/2022
 * Time :2:28 PM
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentTM {
    String studentId;
    String name;
    String address;
    String telNo;
    LocalDate dob;
    String gender;

}
