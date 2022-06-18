package lk.D24.HostelManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

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
public class Student {
    String studentId;
    String name;
    String address;
    String telNo;
    LocalDate date;
    String gender;
}
