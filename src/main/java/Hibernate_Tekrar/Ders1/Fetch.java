package Hibernate_Tekrar.Ders1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class Fetch {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //1.Yol get() methodu

        Employee employee1 = session.get(Employee.class,101);
        System.out.println(employee1);  // Employee{id=101, name='Ahmet', salary=8000}

        System.out.println("---------------------------------------------------------");

        //2.Yol SQL Query ile

        String sqlQuery = "SELECT * FROM employee";
        List<Object []> resultList= session.createSQLQuery(sqlQuery).getResultList();
        for (Object[] w:resultList) {
            System.out.println(Arrays.toString(w));
        }
        /*
        [101, Ahmet, 8000]
        [102, Mehmet, 8500]
        [103, Samet, 9000]
         */
        System.out.println("---------------------------------------------------------");

        //3.Yol HQL ile

        String hqlQuery = "FROM Employee";
        List<Employee> resultList2 =session.createQuery(hqlQuery, Employee.class).getResultList();
        for (Employee w:resultList2) {
            System.out.println(w);
        }
        /*
        Employee{id=101, name='Ahmet', salary=8000}
        Employee{id=102, name='Mehmet', salary=8500}
        Employee{id=103, name='Samet', salary=9000}
         */

        System.out.println("---------------------------------------------------------");

        // uniqueResult() with SQL ******
        String sqlQuery1 ="SELECT * FROM employee WHERE name='Ahmet'";
        Object[] uniqueResult = (Object[]) session.createSQLQuery(sqlQuery1).uniqueResult();
        System.out.println(Arrays.toString(uniqueResult)); // [101, Ahmet, 8000]

        System.out.println("---------------------------------------------------------");

        // uniqueResult() with HQL ******
        String hqlQuery1 ="FROM Employee WHERE name='Mehmet'";  // "FROM Employee(Class adı) WHERE name(field adı)='Mehmet'
        Employee  uniqueResult2 = session.createQuery(hqlQuery1, Employee.class).uniqueResult();
        System.out.println(uniqueResult2);  // Employee{id=102, name='Mehmet', salary=8500}


        tx.commit();
        session.close();
        sf.close();
    }
}

/*
Genel Fetch  Yapısı
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();







        tx.commit();
        session.close();
        sf.close();

 */
