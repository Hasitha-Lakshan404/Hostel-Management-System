package lk.D24.HostelManagement.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/17/2022
 * Time :4:29 PM
 */

public interface CrudDAO<T, ID> extends SuperDAO {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException, IOException;

    boolean save(T dto) throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean exist(ID id) throws SQLException, ClassNotFoundException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException;

    String generateNewID() throws SQLException, ClassNotFoundException;

    T search(String id) throws SQLException, ClassNotFoundException;
}