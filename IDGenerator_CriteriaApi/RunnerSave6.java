package Hibernate_Tekrar.IDGenerator_CriteriaApi;

import com.hb10.idgeneration.Student10;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RunnerSave6 {
    public static void main(String[] args) {

        List<Integer> salaries =new ArrayList<>(Arrays.asList(10000,9000,8000,7000,12000));
        List<String> names = new ArrayList<>(Arrays.asList("Ali","Ayşe","Ahmet","Kemal","Burak","Sefa","Serkan","Murat","Sema","Can"));


        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee6.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Random random = new Random();


        for (int i = 1; i <=5 ; i++) {
            Employee6 employee = new Employee6();
            employee.setName(names.get(random.nextInt(9)));
            employee.setMaas(salaries.get(random.nextInt(4)));
            session.save(employee);
        }

        tx.commit();
        session.close();
        sf.close();

    }
}
