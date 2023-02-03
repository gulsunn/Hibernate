package Hibernate_Tekrar.KullanıcıdanAlınanVerileriKaydetme1;

import Hibernate_Tekrar.KullanıcıdanAlınanVerileriKaydetme2.Department;
import Hibernate_Tekrar.KullanıcıdanAlınanVerileriKaydetme2.Employee8;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RunnerSave7 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee7.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        for (int i = 1; i <=10; i++) {

            System.out.println(i+" . Employee adını giriniz :");
            String ad =input.next();

            System.out.println(i+" . Employee Salary Giriniz : ");
            int maas = input.nextInt();

            System.out.println(i+" . Employee Department No Giriniz : ");
            int dep_no = input.nextInt();


            Employee7 employee =new Employee7(ad,maas,dep_no);
            session.save(employee);

        }

        tx.commit();
        session.close();
        sf.close();

    }
}
