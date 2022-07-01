package lk.D24.HostelManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :7/1/2022
 * Time :3:02 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    String userId;
    String name;
    String userName;
    String password;
}
