package lk.D24.HostelManagement.util;

import lk.D24.HostelManagement.entity.Employee;
import lk.D24.HostelManagement.entity.Reserve;
import lk.D24.HostelManagement.entity.Room;
import lk.D24.HostelManagement.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

/**
 * @author : Hasitha Lakshan
 * Project :Hostel_Management_System
 * Date :6/17/2022
 * Time :5:12 PM
 */

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;


    private FactoryConfiguration() throws IOException {
        Configuration configuration = new Configuration();
        Properties p = new Properties();
        p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
        configuration.setProperties(p);

        // configuration.addAnnotatedClass();
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Reserve.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Room.class);

        sessionFactory = configuration.buildSessionFactory();

    }

    public static FactoryConfiguration getInstance() throws IOException {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration()
                : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

}
