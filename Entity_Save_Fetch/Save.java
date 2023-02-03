package Hibernate_Tekrar.Entity_Save_Fetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Save {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setId(101);
        employee1.setName("Ahmet");
        employee1.setSalary(8000);

        Employee employee2 = new Employee();
        employee2.setId(102);
        employee2.setName("Mehmet");
        employee2.setSalary(8500);

        Employee employee3 = new Employee();
        employee3.setId(103);
        employee3.setName("Samet");
        employee3.setSalary(9000);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // session.save(employee1);
        // session.save(employee2);
           session.save(employee3);


        tx.commit();
        session.close();
        sf.close();

    }
}
