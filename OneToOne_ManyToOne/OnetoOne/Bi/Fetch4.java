package Hibernate_Tekrar.OneToOne_ManyToOne.OnetoOne.Bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class Fetch4 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee4.class).addAnnotatedClass(DinnerCard1.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // 1- id'yi 1001 olan sahip employee'ı tüm bilgilerini  getirelim

        Employee4 employee =  session.get(Employee4.class,1001);
        System.out.println(employee); // Employee{id=1001, name='Murat', salary=10000}

        System.out.println("--------------------------------------");


        // 2- id=103 olan dinner cardın tüm bilgilerini getiriniz.

        DinnerCard1 dinnercard = session.get(DinnerCard1.class,103);
        System.out.println(dinnercard); // DinnerCard{id='103', name='No Employee', employee=null}

        System.out.println("--------------------------------------");


        // 3-get() ile id=1002 olan employeenin kullandığı dinner card bilgilerini getiriniz.

        Employee4 employe =session.get(Employee4.class,1002);
        System.out.println(employe.getDinnerCard());

        // HQL ile id=1002 olan employeenin kullandığı dinner card bilgilerini getiriniz. (JOIN' e gerek yok employee_id bilgisi DinnerCard1 tablosunda var)

        String hqlQuery1 = "FROM DinnerCard1 d WHERE d.employee.id=1002"; //employee'nin id sine ulaşmak için HQL De employee.id dedik sonra da 1002 olan ı getir dedik
        DinnerCard1 dinnerCard2 = session.createQuery(hqlQuery1, DinnerCard1.class).uniqueResult(); //uniqueResult çünkü soruda id 1002 olan dediği için bu id li employeenin sahip olduğu tek bir dinner card olduğu için
        System.out.println(dinnerCard2); // null  //1002 id li employee ye dinner Card verilmemiş (setlenmemiş)

        System.out.println("--------------------------------------");

        // 4-get() ile id=102 olan dinner Card ı kullanan employee bilgilerini getiriniz.

        DinnerCard1 dinnercard1= session.get(DinnerCard1.class,102); //102 id li dinner card'ı getir
        System.out.println(dinnercard1.getEmployee()); // Employee{id=1003, name='Kemal', salary=8500} 102 no lu dinnerCard'ın employee bilgisini getir

/*
             ?????????????????????????????
        // HQL ile  id=102 olan dinner Card ı kullanan employee bilgilerini getiriniz.  (JOIN e gerek var dinner card id bilgisi Employee tablosunda yok )
        String hqlQuery2 ="SELECT e.name,d.name FROM Employee4 e INNER JOIN FETCH  DinnerCard1 d WHERE d.id=102";  // Çalışmıyor ???????
        List<Object[]> resultList= session.createQuery(hqlQuery2).getResultList();
        System.out.println("HQL:102 id'li DinnerCard Employee Bilgileri");
        resultList.forEach(r1-> System.out.println(Arrays.toString(r1)));

 */
        System.out.println("--------------------------------------");

        // HQL INNER JOIN
        //3- Kesişim kümesini getirelim (Dinner Card' a sahip olan işçiler)

        String hqlQuery4 = "SELECT e.name,d.name FROM Employee4 e INNER JOIN FETCH DinnerCard1 d ON e.id=d.employee";  // employee_id fieldına gitmes i için d.employee yazılır yoksa d.id yazarsak DinnerCard id ye gider (d.employee ile de çalıştı d.employee.id ile de)
        List<Object[]> resultList1 = session.createQuery(hqlQuery4).getResultList(); // e.name,d.name farklı tablolardan er i geleceği için createQuery() içinde Class adı ike data type yazmadık
        System.out.println("INNER JOIN");
        resultList1.forEach(r-> System.out.println(Arrays.toString(r)));

        // SQL hali : "SELECT s.name,d.name FROM employee4 s INNER JOIN dinnerCard4 d ON e.id=d.employee_id

        System.out.println("--------------------------------------");

        // HQL LEFT JOIN
        // 4- Kısaca bütün employees ve dinner card'ı olan employeeleri istiyorum
        String hqlQuery5 = "SELECT e.name,d.name FROM Employee4 e LEFT JOIN DinnerCard1 d ON e.id=d.employee.id";
        List<Object[]> resultSet2 = session.createQuery(hqlQuery5).getResultList();
        System.out.println("LEFT JOIN");
        resultSet2.forEach(r-> System.out.println(Arrays.toString(r)));

        System.out.println("--------------------------------------");

        // HQL RIGHT JOIN
        // Kısaca bütün dinner cardları  ve dinner card'i olan employeeleri istiyorum
        String hqlQuery6 = "SELECT e.name,d.name FROM Employee4 e RIGHT JOIN DinnerCard1 d ON e.id=d.employee.id";
        List<Object[]> resultSet3 = session.createQuery(hqlQuery6).getResultList();
        System.out.println("RIGHT JOIN");
        resultSet3.forEach(r-> System.out.println(Arrays.toString(r)));

        System.out.println("--------------------------------------");

        // FULL JOIN
        // Bütün employeeleri'leri ve dinner card'lari getir (Birleşim)
        String hqlQuery7 = "SELECT e.name,d.name FROM Employee4 e FULL JOIN DinnerCard1 d ON e.id = d.employee.id";
        List<Object[]> resultSet4 = session.createQuery(hqlQuery7).getResultList();
        System.out.println("FULL JOIN");
        resultSet4.forEach(r-> System.out.println(Arrays.toString(r)));

        tx.commit();
        session.close();
        sf.close();

    }
}

/*
        INNER JOIN
        Output :
        [Murat, DinnerCard101Murat]
        [Kemal, DinnerCard102Kemal]

        LEFT JOIN
        Output:
        [Murat, DinnerCard101Murat]
        [Kemal, DinnerCard102Kemal]
        [Ahmet, null]

        RIGHT JOIN
        Output:
        [Murat, DinnerCard101Murat]
        [Kemal, DinnerCard102Kemal]
        [null, No Employee]

        FULL JOIN
         Output:
        [Murat, DinnerCard101Murat]
        [Kemal, DinnerCard102Kemal]
        [null, No Employee]
        [Ahmet, null]

*/
