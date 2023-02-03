package Hibernate_Tekrar.KullanıcıdanAlınanVerileriKaydetme2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch8 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee8.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // Criteria API Boiler Plate
        CriteriaBuilder cb =session.getCriteriaBuilder();
        CriteriaQuery<Employee8> criteriaQuery=cb.createQuery(Employee8.class);
        Root<Employee8> root = criteriaQuery.from(Employee8.class);


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
