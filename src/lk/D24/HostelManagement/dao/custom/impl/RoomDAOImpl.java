package lk.D24.HostelManagement.dao.custom.impl;

import lk.D24.HostelManagement.dao.custom.RoomDAO;
import lk.D24.HostelManagement.entity.Room;
import lk.D24.HostelManagement.util.FactoryConfiguration;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/17/2022
 * Time :4:58 PM
 */

public class RoomDAOImpl implements RoomDAO {
    Session session;

    {
        try {
            session = FactoryConfiguration.getInstance().getSession();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    Transaction transaction=session.beginTransaction();


    @Override
    public ArrayList<Room> getAll() {
        Criteria criteria = session.createCriteria(Room.class);
        List rooms = criteria.list();

        ArrayList<Room> allRoom = new ArrayList<>(rooms);

        transaction.commit();
        session.close();
        return allRoom;
    }

    @Override
    public boolean save(Room entity)  {
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room entity) {
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) {
        Room load = session.load(Room.class, s);
        session.delete(load);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public String generateNewID() {
        return null;
    }

    @Override
    public Room search(String id) {
        return null;
    }
}
