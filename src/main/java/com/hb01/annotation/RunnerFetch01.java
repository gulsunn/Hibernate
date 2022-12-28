package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {

        //1.Adım Configürasyon oluştur
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class); //Configurasyonumuz hazır

        //2.Adım Session oluştur
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        //Bağlantı kuruldu

        //3.Adım Transaction başlat
        Transaction tx = session.beginTransaction();

        //DB bir bigiyi fetchlemek(almak) için 3 yol var
        // 1) get()
        // 2) SQL
        // 3) HQL
        // (3-1-2)



        /*
        // 1.Yol: get() methodu
        Student01 student1 = session.get(Student01.class,1001); // session.get(data türü,id)  get()  methodu id ile çalışır
        Student01 student2 = session.get(Student01.class,1002);
        Student01 student3 = session.get(Student01.class,1003);


        System.out.println(student1); //To String'in çıktısı gelir student1 objesini yazar
        System.out.println(student2);
        System.out.println(student3);


         */
//   -----------------------------------------------------------------------------------------------------

         /*

        // 2.Yol  SQL
        String sqlQuery = "SELECT * FROM  t_student01";
        List<Object[]> resultList = session.createSQLQuery(sqlQuery).getResultList();
        for (Object[] object:resultList) { //Fieldları da olduğu için  arraylar aldık Object türünde aldık çümkü farklı data tipleri içerir bir array :Object[]
            System.out.println(Arrays.toString(object));
        }

         */


 //  -----------------------------------------------------------------------------------------------------

        // 3.Yol HQL   (HQL yazarken tablo ve Header ismi yazmayız bunun yerine JAVAca ifadeler kullanırız)
        // Trick:SQL sorgusunda FROM' dan sonra sınıf ismi kullanılmalı

        String hqlQuery = "FROM Student01";  //FROM dan sonra Class adı yazıldı  //Select * yazmaya gerek yok
        List<Student01>resultList2 = session.createQuery(hqlQuery, Student01.class).getResultList();  // getResultList() List döndürür
        for (Student01 student01:resultList2) {
            System.out.println(student01);
        }



 //  -----------------------------------------------------------------------------------------------------

         // uniqueResult() with SQL ******
         // Dönecek kaydın unique( tek bir tane) olduğundan emin iseniz uniqueResult() methodu kullanılabilir

 //       String sqlQuery2 ="SELECT * FROM t_student01 WHERE student_name='Tarık'";
 //       Object[] uniqueResult1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult(); // getResult() yerine uniqueResult() kullandık. List<Object[]> yerinede ,Object[] kullandık
 //       System.out.println(Arrays.toString(uniqueResult1));

//        yukarda 1 obje gelecek ama içinde kolonlar olduğu için array türünde obje geldi
//        System.out.println(uniqueResult1[0] + " : "+ uniqueResult1[1] + " : " + uniqueResult1[2]);

 //  -----------------------------------------------------------------------------------------------------

        // uniqueResult() with HQL ******
 //       String hqlQuery2 ="FROM Student01 WHERE name='Tarık'";
 //       Student01 uniqueResult2 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
 //       System.out.println(uniqueResult2);  //hql sorgusunda objenin kendisi gelir-->Student01{id=1002, name='Tarık', grade=95}

        //********************** THE END ****************************************************


        tx.commit();
        session.close();
        sf.close();

    }


    /*
     Transaction tx = session.beginTransaction();




      yapacağımız tüm işlemler burada




        tx.commit();
     */

    // HQL:Java Classlarını SQl komutları ile birleştirip data base'e gönderme
    //    :Java ca sorgu yazma
}

/*
1.Yol:get() methodu çıktısı

Student01{id=1001, name='Gulsun Gumus', grade=90}
Student01{id=1002, name='Tarık', grade=95}
Student01{id=1003, name='Miraç', grade=80}

----------------------------------------------
2.Yol :SQL Query Çıktısı
String sqlQuery = "SELECT * FROM  t_student01";

[1001, 90, Gulsun Gumus]
[1002, 95, Tarık]
[1003, 80, Miraç]

----------------------------------------------
3.Yol : HQL Query Çıktısı
String hqlQuery = "FROM Student01";

Student01{id=1001, name='Gulsun Gumus', grade=90}
Student01{id=1002, name='Tarık', grade=95}
Student01{id=1003, name='Miraç', grade=80}

----------------------------------------------

uniqueResult() with SQL çıktısı

 SELECT * FROM t_student01 WHERE student_name='Tarık'
 [1002, 95, Tarık]

 ----------------------------------------------
uniqueResult() with HQL çıktısı

String hqlQuery2 ="FROM Student01 WHERE name='Tarık'";

Student01{id=1002, name='Tarık', grade=95}

 */
