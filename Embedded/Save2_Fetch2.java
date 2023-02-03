package Hibernate_Tekrar.Embedded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Save2_Fetch2 {
    public static void main(String[] args) {
        Adres adres1 =new Adres();
        adres1.setCadde("Andıl");
        adres1.setSehir("Adana");
        adres1.setUlke("Türkiye");

        Employee2 employee1= new Employee2();
        employee1.setId(1001);
        employee1.setName("Ali");
        employee1.setSalary(9000);
        employee1.setAdres(adres1);

        Adres adres2 =new Adres();
        adres2.setCadde("Menekşe");
        adres2.setSehir("Ankara");
        adres2.setUlke("Türkiye");

        Employee2 employee2= new Employee2();
        employee2.setId(1002);
        employee2.setName("Ahmet");
        employee2.setSalary(10000);
        employee2.setAdres(adres2);



        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee2.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // Save
        // session.save(employee1);
        // session.save(employee2);

        //Fetch
        Employee2 employee01 = session.get(Employee2.class,1001);  // 1001 id'li recordun bilgilerini getirir. Employee{id=1001, name='Ali', salary=9000}
        System.out.println(employee01);
        System.out.println(employee1.getAdres()); // Adres{cadde='Andıl', sehir='Adana', ulke='Türkiye'}


        tx.commit();

        session.close();
        sf.close();
    }
}
