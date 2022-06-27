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
    ArrayList<T> getAll() throws IOException;

    boolean save(T entity) throws IOException;

    boolean update(T entity) throws IOException;

    boolean delete(ID id) throws IOException;

    String generateNewID() throws IOException;

    T search(String id) ;
}