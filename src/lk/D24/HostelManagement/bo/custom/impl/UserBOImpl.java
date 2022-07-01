package lk.D24.HostelManagement.bo.custom.impl;

import lk.D24.HostelManagement.bo.custom.UserBO;
import lk.D24.HostelManagement.dao.custom.UserDAO;
import lk.D24.HostelManagement.dao.custom.impl.UserDAOImpl;
import lk.D24.HostelManagement.dto.RoomDTO;
import lk.D24.HostelManagement.dto.UserDTO;
import lk.D24.HostelManagement.entity.Room;
import lk.D24.HostelManagement.entity.User;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :7/1/2022
 * Time :3:56 PM
 */

public class UserBOImpl implements UserBO {

    UserDAO userDAO=new UserDAOImpl();

    @Override
    public ArrayList<UserDTO> getAllUser() throws IOException {

        ArrayList<User> all = userDAO.getAll();

        ArrayList<UserDTO> ud = new ArrayList<>();


        for (User user : all) {
            ud.add(new UserDTO(
                    user.getUserId(),
                    user.getName(),
                    user.getUserName(),
                    user.getPassword()
            ));
        }

        return ud;
    }

}
