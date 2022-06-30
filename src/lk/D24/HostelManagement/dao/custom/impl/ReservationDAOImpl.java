package lk.D24.HostelManagement.dao.custom.impl;

import lk.D24.HostelManagement.dao.custom.ReservationDAO;
import lk.D24.HostelManagement.entity.Reserve;
import lk.D24.HostelManagement.entity.Room;
import lk.D24.HostelManagement.util.FactoryConfiguration;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/29/2022
 * Time :1:47 AM
 */

public class ReservationDAOImpl implements ReservationDAO {

    @Override
    public ArrayList<Reserve> getAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Reserve.class);
        List reserve = criteria.list();

        ArrayList<Reserve> custom = new ArrayList<>(reserve);


        transaction.commit();
        session.close();
        return custom;

    }

    @Override
    public boolean save(Reserve entity) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Reserve entity) throws IOException {
        return false;
    }

    @Override
    public boolean delete(String s) throws IOException {
        return false;
    }

    @Override
    public String generateNewID() throws IOException {
        return null;
    }

    @Override
    public Reserve search(String id) {
        return null;
    }

    @Override
    public List<Reserve> searchReservedRoomById(String id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Reserve WHERE room = :roomTypeId";
        Query query = session.createQuery(hql);

        Room room = new Room();
        room.setRoomTypeId(id);

        query.setParameter("roomTypeId", room);
        List<Reserve> r = query.list();

        transaction.commit();
        session.close();

        return r;
    }

}
