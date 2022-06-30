package lk.D24.HostelManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/30/2022
 * Time :11:25 PM
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomEntity {
    String studentId;
    String name;
    String address;
    String telNo;
    LocalDate dob;
    String gender;

    private String roomTypeId;
    private String type;
    private double keyMoney;
    private int qty;

    String resId;
    LocalDate date;
    Student regStudentId;
    Room regRoomId;
    String status;
}
