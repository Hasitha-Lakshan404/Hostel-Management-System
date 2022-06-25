package lk.D24.HostelManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @Id
    private String studentId;
    private String name;
    private String address;
    private String telNo;
    private LocalDate date;
    private String gender;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Reserve> reservation;

    public Student(String studentId, String name, String address, String telNo, LocalDate date, String gender) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.telNo = telNo;
        this.date = date;
        this.gender = gender;
    }
}
