package test;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveObjectTest {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        Transaction transaction = null;
        Session session = null;

        Employee employee = new Employee();


        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            session = sessionFactory.openSession();

            employee.setEid(101);
            employee.setFirstName("Alimardon");
            employee.setLastName("Umidov");
            employee.setEmail("umidov@gmail.com");

            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();

            System.out.println("Done");

        }


    }


}
