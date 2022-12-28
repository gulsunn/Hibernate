package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {

        Student01 student1 = new Student01(); //Student01 Entity Class'ından ürettiğimiz bir student objesi

        student1.setId(1001);
        student1.setName("Gulsun Gumus");
        student1.setGrade(90);

        Student01 student2 = new Student01();

        student2.setId(1002);
        student2.setName("Tarık");
        student2.setGrade(95);

        Student01 student3 = new Student01();
        student3.setId(1003);
        student3.setName("Miraç");
        student3.setGrade(80);

        //Entity Class oluşturuldu ve bilgiler girildi

        //Hibernate'e kaydetmeden önce xml  configürasyon dosyasının ve Entity Class'ın yerini/adını söyleyeceğiz

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        //Hibernate'e konfigürasyon dosyamı ve Entity Class'ımı bildirdim

        //Şimdi bir session oluşturacağız
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();//Transactionu başlat

        // session.save(student1);// save(Object alır)
        // session.save(student2);
           session.save(student3);
        //Birini çalıştırıken diğerlerini kapat


        tx.commit();//Database'e gidip her şeyi yazar. commit yapmazsak DB'ye gitmez  (begin transaction la commit arası gider)

        session.close();
        sf.close();

    }
}


