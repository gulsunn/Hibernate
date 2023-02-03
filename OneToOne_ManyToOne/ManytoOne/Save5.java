package Hibernate_Tekrar.OneToOne_ManyToOne.ManytoOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Save5 {
    public static void main(String[] args) {

        Employee5 employee1 =new Employee5();
        employee1.setId(1001);
        employee1.setName("Kerem");
        employee1.setSalary(9000);

        Employee5 employee2 =new Employee5();
        employee2.setId(1002);
        employee2.setName("Mehmet");
        employee2.setSalary(9000);

        Employee5 employee3 =new Employee5();
        employee3.setId(1003);
        employee3.setName("Serkan");
        employee3.setSalary(9000);

        Employee5 employee4 =new Employee5();
        employee4.setId(1004);
        employee4.setName("Efe");
        employee4.setSalary(9000);

        Employee5 employee5 =new Employee5();
        employee5.setId(1005);
        employee5.setName("Burak");
        employee5.setSalary(9000);

        Transporter transporter1 = new Transporter();
        transporter1.setPlaka("34TYB456");
        transporter1.setMarka("Wolksvagen");
        transporter1.setModel(2018);
        transporter1.setGuzergah("Anadolu Yakası");

        Transporter transporter2 = new Transporter();
        transporter2.setPlaka("34HK4328");
        transporter2.setMarka("Hyundai");
        transporter2.setModel(2020);
        transporter2.setGuzergah("Avrupa Yakası");

        employee1.setTransporter(transporter1);
        employee2.setTransporter(transporter2);
        employee4.setTransporter(transporter1);
        employee5.setTransporter(transporter1);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee5.class).addAnnotatedClass(Transporter.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        //Save

        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.save(employee4);
        session.save(employee5);

        session.save(transporter1);
        session.save(transporter2);


        tx.commit();
        session.close();
        sf.close();

    }
}
