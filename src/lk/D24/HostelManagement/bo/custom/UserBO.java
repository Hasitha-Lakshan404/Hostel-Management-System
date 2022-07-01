package lk.D24.HostelManagement.bo.custom;

import lk.D24.HostelManagement.dto.UserDTO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :7/1/2022
 * Time :3:56 PM
 */

public interface UserBO {
    public ArrayList<UserDTO> getAllUser() throws IOException;

}
