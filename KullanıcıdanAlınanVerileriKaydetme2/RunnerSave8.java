package Hibernate_Tekrar.KullanıcıdanAlınanVerileriKaydetme2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RunnerSave8 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Department department1 =new Department();
        department1.setDepartment_name("DEP1");
        department1.setDepartment_no(1);
        Department department2 =new Department();
        department2.setDepartment_name("DEP2");
        department2.setDepartment_no(2);
        Department department3 =new Department();
        department3.setDepartment_name("DEP3");
        department3.setDepartment_no(3);

        List<Department> departments =new ArrayList<>();//ratsgele department atayabilmek için oluşturdum
        departments.add(department1);
        departments.add(department2);
        departments.add(department3);

        Random random = new Random();

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee8.class).addAnnotatedClass(Department.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(department1);
        session.save(department2);
        session.save(department3);


        for (int i = 1; i <=5 ; i++) {

            System.out.println(i+" . Employee adını giriniz :");
            String ad =input.next();

            System.out.println(i+" . Employee Salary Giriniz : ");
            int maas = input.nextInt();


            Employee8 employee =new Employee8(ad,maas);//id otomatik ad ve maaş ı kullanıcıdan aldım
            int idx = random.nextInt(3);
            employee.setDepartment(departments.get(idx));//Rastgele department atadım
            session.save(employee);

        }

        tx.commit();
        session.close();
        sf.close();

    }
}
