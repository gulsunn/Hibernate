package Hibernate_Tekrar.KullanıcıdanAlınanVerileriKaydetme1;

import Hibernate_Tekrar.KullanıcıdanAlınanVerileriKaydetme2.Employee8;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch7 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee8.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // Criteria API Boiler Plate
        CriteriaBuilder cb =session.getCriteriaBuilder();
        CriteriaQuery<Employee8> criteriaQuery=cb.createQuery(Employee8.class);
        Root<Employee8> root = criteriaQuery.from(Employee8.class);

        // employee7 tablosundaki tüm employee leri getir.

        criteriaQuery.select(root);
        List<Employee8> employee7List =session.createQuery(criteriaQuery).getResultList();
        employee7List.forEach(System.out::println);

        /*
        İlk olarak ad maas ve department noyu kullanıcıdan aldığım 10 kişilik bir employeee tablosu oluşturmuştum
        Employee7{id=1, name='Ali', salary=5000, departpment_no=2}
        Employee7{id=2, name='Mehmet', salary=6000, departpment_no=4}
        Employee7{id=3, name='Ahmet', salary=4500, departpment_no=3}
        Employee7{id=4, name='Elif', salary=6000, departpment_no=2}
        Employee7{id=5, name='Erkan', salary=4500, departpment_no=3}
        Employee7{id=6, name='Recep', salary=5000, departpment_no=3}
        Employee7{id=7, name='Serdar', salary=5500, departpment_no=2}
        Employee7{id=8, name='Hasan', salary=6500, departpment_no=1}
        Employee7{id=9, name='Suna', salary=4500, departpment_no=1}
        Employee7{id=10, name='Tarık', salary=5000, departpment_no=4}
         */

        // employee7 tablosundaki maaş'u 5000 den düşük olan  employee leri getir.
        criteriaQuery.select(root).where(cb.lessThan(root.get("salary"),5000));
        List<Employee8> employeelessthan5000 =session.createQuery(criteriaQuery).getResultList();
        employeelessthan5000.forEach(System.out::println);
        /*
        Employee7{id=3, name='Ahmet', salary=4500, departpment_no=3}
        Employee7{id=5, name='Erkan', salary=4500, departpment_no=3}
        Employee7{id=9, name='Suna', salary=4500, departpment_no=1}
         */

        tx.commit();
        session.close();
        sf.close();

    }
}

/*
  İlk olarak ad maas ve department noyu kullanıcıdan aldığım 10 kişilik bir employeee tablosu oluşturmuştum
  ve bu cıktılar bu tabloya ait
  daaha sonra
 */
