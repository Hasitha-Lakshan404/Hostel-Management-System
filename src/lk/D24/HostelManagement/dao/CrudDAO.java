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
    ArrayList<T> getAll() ;

    boolean save(T entity) ;

    boolean update(T entity) ;

    boolean delete(ID id) ;

    String generateNewID() ;

    T search(String id) ;
}