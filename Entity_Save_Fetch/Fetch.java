package Hibernate_Tekrar.Entity_Save_Fetch;

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
        System.out.println("--GET()--");
        System.out.println(employee1);  // Employee{id=101, name='Ahmet', salary=8000}

        System.out.println("---------------------------------------------------------");

        // 2.Yol SQL Query ile
        // Tüm datayı çekiniz

        String sqlQuery = "SELECT * FROM employee";  //Sorguyu yaz ve String bir değişkene ata
        List<Object []> resultList= session.createSQLQuery(sqlQuery).getResultList(); //session vasıtası ile createSQLQuery() methodunu kullanarak bu sorguyu çalıştır  --> getResultList() ile sorgu sonucun döndür-->dönen resultList'i Object [] türünde bir liste koy  (SQl sorgusu sonucunda Object türünde array gelir)
        System.out.println("--SQl--");
        for (Object[] w:resultList) {  //resultList değişkenine atadığımız srogu sonucunu for each döngüsü ile teker teker yazdır
            System.out.println(Arrays.toString(w)); //Array döndüğü için Arrays.toString() ile yazdırdık
        }
        /*
        [101, Ahmet, 8000]
        [102, Mehmet, 8500]
        [103, Samet, 9000]
         */
        System.out.println("---------------------------------------------------------");

        // 3.Yol HQL ile
        // Tüm datayı çekiniz

        String hqlQuery = "FROM Employee";
        List<Employee> resultList2 =session.createQuery(hqlQuery, Employee.class).getResultList();
        System.out.println("--HQL--");
        for (Employee w:resultList2) {
            System.out.println(w);
        }
        /*
        Employee{id=101, name='Ahmet', salary=8000}
        Employee{id=102, name='Mehmet', salary=8500}
        Employee{id=103, name='Samet', salary=9000}
         */

        System.out.println("---------------------------------------------------------");

        // SQL ile Adı Ahmet olan işçiye ait verileri getiriniz
        String sqlQuery2 = "SELECT * FROM employee WHERE name='Ahmet'";
        System.out.println("--SQL-WHERE--");
        List<Object[]> resultList3 = session.createSQLQuery(sqlQuery2).getResultList(); //uniqueResult kullanmadık çünkü adı ahmet olan birden fazla kayıt olabilir
        for (Object[] objects:resultList3) {
            System.out.println(Arrays.toString(objects));  //[101, Ahmet, 8000]
        }

        // HQL ile Adı Mehmet olan işçiye ait verileri getiriniz
        String hqlQuery2 = "FROM Employee WHERE name = 'Mehmet'";// HQL yazarken SELECT * yazmaya gerek yok
        System.out.println("--HQL-WHERE--");
        List<Employee> resultList4 =session.createQuery(hqlQuery2, Employee.class).getResultList();
        for (Employee employee:resultList4) {
            System.out.println(employee); // Employee{id=102, name='Mehmet', salary=8500}
        }

        System.out.println("---------------------------------------------------------");

        // uniqueResult() with SQL ******
        // 101 id li işçiye ait verileri getiriniz

        String sqlQuery3 ="SELECT * FROM employee WHERE id=101";
        System.out.println("SQL-uniqueResult");
        Object[] uniqueResult = (Object[]) session.createSQLQuery(sqlQuery3).uniqueResult(); //id si 101 olan tek bir işçi olabileceğinden dolayı tek bir kayıt geleceğinden  emin olduğumuz için getResultList() yerine  uniqeResult() kullandık
        System.out.println(Arrays.toString(uniqueResult)); // [101, Ahmet, 8000]

        System.out.println("---------------------------------------------------------");

        // uniqueResult() with HQL ******
        // 102 id li işçiye ait verileri getiriniz

        String hqlQuery3 ="FROM Employee WHERE id=102";  // "FROM Employee(Class adı) WHERE name(field adı)='Mehmet'
        System.out.println("HQL-uniqueResult");
        Employee  uniqueResult2 = session.createQuery(hqlQuery3, Employee.class).uniqueResult();
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
