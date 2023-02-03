package Hibernate_Tekrar.OneToOne_ManyToOne.OnetoOne.Uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Seve3_Fetch3 {
    public static void main(String[] args) {
        Employee3 employee1 = new Employee3();
        employee1.setId(1001);
        employee1.setName("Murat");
        employee1.setSalary(10000);

        Employee3 employee2= new Employee3();
        employee1.setId(1002);
        employee1.setName("Sinan");
        employee1.setSalary(9000);  //henüz sav etmedim




        DinnerCard dinnerCard1=new DinnerCard();
        dinnerCard1.setId(101);
        dinnerCard1.setName("DinnerCard101Murat");
        dinnerCard1.setEmployee(employee1);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee3.class).addAnnotatedClass(DinnerCard.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        //Save
       // session.save(employee1);
       // session.save(dinnerCard1);

        //Student Fetch
        Employee3 employee = session.get(Employee3.class,1001);
        System.out.println(employee); //Employee{id=1001, name='Murat', salary=10000}

        //DinnerCard Fetch
        DinnerCard dinnerCard = session.get(DinnerCard.class,101);
        System.out.println(dinnerCard); // DinnerCard{id='101', name='DinnerCard101Murat', employee=Employee{id=1001, name='Murat', salary=10000}}

        System.out.println("*********");
        System.out.println(dinnerCard1.getEmployee());  // Employee{id=1001, name='Murat', salary=10000}



        tx.commit();
        session.close();
        sf.close();

    }
}
