package Hibernate_Tekrar.OneToOne_ManyToOne.ManytoOne;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Fetch5 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee5.class).addAnnotatedClass(Transporter.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // 1- 1001 id'li Employee'nin tüm bilgilerini  getir

        //1.Yol Get ile
        Employee5 employee1001 = session.get(Employee5.class,1001);
        System.out.println("get()");
        System.out.println(employee1001);  // Employee05{id=1001, name='Kerem', salary=9000, transporter=Transporter{plaka='34TYB456', marka='Wolksvagen', model='2018'}}


        //2.Yol HQL ile
        String hqlQuery  = "FROM Employee5 e WHERE e.id=1001";
        Employee5 employee1001hql = session.createQuery(hqlQuery, Employee5.class).uniqueResult();
        System.out.println("HQL");
        System.out.println(employee1001hql); // Employee05{id=1001, name='Kerem', salary=9000, transporter=Transporter{plaka='34TYB456', marka='Wolksvagen', model='2018'}}


        // 2- 1002 id'li employee'nin transporter bilgisini getir

        Employee5 employee1002 = session.get(Employee5.class,1002);
        System.out.println("getTransporter");
        System.out.println(employee1002.getTransporter()); // Transporter{plaka='34HK4328', marka='Hyundai', model='2020'}


        // 3- "34TYB456" plakalı transporter ı kullanan employee leri bul
        // get() ile bulamayız çünkü çift taraflı yapmadık

        //HQL ile  (JOIN'e gerek yok çünkü transporter_plaka bilgisi employee5 tablosunda var)
        String hqlQuery1 = "FROM Employee5 e WHERE e.transporter.plaka='34TYB456'";
        List<Employee5> employees = session.createQuery(hqlQuery1, Employee5.class).getResultList();
        System.out.println("HQL Employee");
        for (Employee5 employee:employees) {
            System.out.println(employee);
        }

        /*
        HQL Employee
        Employee05{id=1001, name='Kerem', salary=9000, transporter=Transporter{plaka='34TYB456', marka='Wolksvagen', model='2018'}}
        Employee05{id=1004, name='Efe', salary=9000, transporter=Transporter{plaka='34TYB456', marka='Wolksvagen', model='2018'}}
        Employee05{id=1005, name='Burak', salary=9000, transporter=Transporter{plaka='34TYB456', marka='Wolksvagen', model='2018'}}
         */

        tx.commit();
        session.close();
        sf.close();
    }
}
