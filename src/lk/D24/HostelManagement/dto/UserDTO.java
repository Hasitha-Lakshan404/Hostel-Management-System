package lk.D24.HostelManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :7/1/2022
 * Time :3:44 PM
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    String userId;
    String name;
    String userName;
    String password;
}
