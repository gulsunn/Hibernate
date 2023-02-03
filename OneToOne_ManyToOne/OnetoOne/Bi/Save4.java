package Hibernate_Tekrar.OneToOne_ManyToOne.OnetoOne.Bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Save4 {
    public static void main(String[] args) {
        Employee4 employee1 = new Employee4();
        employee1.setId(1001);
        employee1.setName("Murat");
        employee1.setSalary(10000);

        Employee4 employee2 = new Employee4();
        employee2.setId(1002);
        employee2.setName("Ahmet");
        employee2.setSalary(9000);

        Employee4 employee3 = new Employee4();
        employee3.setId(1003);
        employee3.setName("Kemal");
        employee3.setSalary(8500);


        DinnerCard1 dinnerCard1=new DinnerCard1();
        dinnerCard1.setId(101);
        dinnerCard1.setName("DinnerCard101Murat");
        dinnerCard1.setEmployee(employee1);//İlişki sahibi DinnerCard1 olduğu için set methodunu dinnerCard1 üzerinden kullandık
        // employee1.setDinnerCard(dinnerCard1) bu şekilde diyemeyiz çünkü null gelir (Zaten ben setDinnerCard methodu tanımlamamıştım)

        DinnerCard1 dinnerCard2 = new DinnerCard1();
        dinnerCard2.setId(102);
        dinnerCard2.setName("DinnerCard102Kemal");
        dinnerCard2.setEmployee(employee3);

        DinnerCard1 dinnerCard3 = new DinnerCard1();
        dinnerCard3.setId(103);
        dinnerCard3.setName("No Employee");



        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee4.class).addAnnotatedClass(DinnerCard1.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        //Save

        session.save(employee1);
        session.save(dinnerCard1);
        session.save(employee2);
        session.save(employee3);
        session.save(dinnerCard2);
        session.save(dinnerCard3);


        tx.commit();
        session.close();
        sf.close();

    }
}
