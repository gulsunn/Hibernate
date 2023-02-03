package Hibernate_Tekrar.IDGenerator_CriteriaApi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch6 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee6.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // 3 id'li Employee nin bilgilerini getir
        Employee6 employee3 =session.get(Employee6.class,3L);
        System.out.println("3 id'li Employee Bilgileri");
        System.out.println(employee3);// Employee6{id=3, name='Sema', maas=7000}
        System.out.println(employee3.getName()); //3 id'li Employee nin sadece adını getir : Sema

        System.out.println("-----------------------------------------------");

        // 2 id li Employee'nin adını Mehmet olarak güncelle
        Employee6 employee2 =session.get(Employee6.class,2L);
        employee2.setName("Mehmet");

        System.out.println("-----------------------------------------------");

        // maası 10000 olan Employee'leri bul
        String hql ="FROM Employee6 e  WHERE e.maas=10000";
        List<Employee6> maas1000 = session.createQuery(hql, Employee6.class).getResultList();
        System.out.println("Maası 10000 olan Employeeler");
        maas1000.forEach(System.out::println);
        /*
        Maası 10000 olan Employeeler
        Employee6{id=4, name='Ahmet', maas=10000}
        Employee6{id=2, name='Mehmet', maas=10000}
         */

        System.out.println("-----------------------------------------------");

         // Maası 9000 olan Employee'leri bul
         // Benzer soruyu  HQl query'yi parametrize ederek dinamik hale getirerek çözelim
        int A = 9000;
        String hql1 ="FROM Employee6 e  WHERE e.maas=:A";
        Query query = session.createQuery(hql1);  // query oluştur
        query.setParameter("A",A); // query nin parametre(ler)sini setledik (query çağırılmaya hazır)
        List<Object> maas9000 = query.getResultList(); //query nin sonucunu çağırdık
        System.out.println("Maası 9000 olan Employee'ler");
        maas9000.forEach(System.out::println);// Employee6{id=5, name='Sema', maas=9000}



        System.out.println("-------******* Criteria API*****----------------");

        //Boiler Plate
        CriteriaBuilder cb =session.getCriteriaBuilder();
        CriteriaQuery<Employee6> criteriaQuery=cb.createQuery(Employee6.class);
        Root<Employee6> root = criteriaQuery.from(Employee6.class);

        // employee6 tablosundaki tüm Employee leri getir (Criteria Api ile)

        criteriaQuery.select(root);  //Sorgu oluştur (select(root) tüm dataları getirir Select * From employee6 demişiz gibi)
        List<Employee6> resultList =session.createQuery(criteriaQuery).getResultList();
        System.out.println("employee6 tablosundaki tüm Employeeler");
        resultList.forEach(System.out::println);
        /*
        employee6 tablosundaki tüm Employee'ler
        Employee6{id=3, name='Sema', maas=7000}
        Employee6{id=4, name='Ahmet', maas=10000}
        Employee6{id=5, name='Sema', maas=9000}
        Employee6{id=6, name='Sefa', maas=7000}
        Employee6{id=2, name='Mehmet', maas=10000}
         */

        System.out.println("-----------------------------------------------");

        // employee6 tablosundaki maaşı 7000 olan Employee leri getir (Criteria Api ile)

        criteriaQuery.select(root).where(cb.equal(root.get("maas"),7000));
        List<Employee6> resultList2 =session.createQuery(criteriaQuery).getResultList();
        System.out.println("Employee6 tablosundaki maaşı 7000 olan Employee ler");
        resultList2.forEach(System.out::println);
        /*
        Employee6 tablosundaki maaşı 7000 olan Employee ler
        Employee6{id=3, name='Sema', maas=7000}
        Employee6{id=6, name='Sefa', maas=7000}
         */

        System.out.println("-----------------------------------------------");

        // employee6 tablosundaki maaşı 9000 ve daha büyük olan Employee leri getir (Criteria Api ile)

        criteriaQuery.select(root).where(cb.greaterThanOrEqualTo(root.get("maas"),9000));
        List<Employee6>resultList3 = session.createQuery(criteriaQuery).getResultList();
        System.out.println("Employee6 tablosundaki maaşı 9000 ve daha büyük olan Employee ler");
        resultList3.forEach(System.out::println);
        /*
        Employee6 tablosundaki maaşı 9000 ve daha büyük olan Employee ler
        Employee6{id=4, name='Ahmet', maas=10000}
        Employee6{id=5, name='Sema', maas=9000}
        Employee6{id=2, name='Mehmet', maas=10000}
         */

        System.out.println("-----------------------------------------------");

        // employee6 tablosundaki adı "Sema" olan Employee leri getir (Criteria Api ile)
        criteriaQuery.select(root).where(cb.equal(root.get("name"),"Sema"));
        List<Employee6> resultList4 = session.createQuery(criteriaQuery).getResultList();
        System.out.println("employee6 tablosundaki adı Sema olan Employee'ler");
        resultList4.forEach(System.out::println);
        /*
        employee6 tablosundaki adı Sema olan Employee'ler
        Employee6{id=3, name='Sema', maas=7000}
        Employee6{id=5, name='Sema', maas=9000}
         */

        System.out.println("-----------------------------------------------");

        // employee6 tablosundaki maası 9000 den küçük veya  adı "Sema" olan Employee leri getir (Criteria Api ile)
        // 1.şart : maası 9000 den küçük
        // 2.şart : adı "Sema" olan

        Predicate predicateForMaas =cb.lessThan(root.get("maas"),9000);
        Predicate predicateForAd =cb.equal(root.get("name"),"Sema");
        Predicate predicate = cb.or(predicateForMaas,predicateForAd);

        criteriaQuery.select(root).where(predicate);
        List<Employee6> resultList5 = session.createQuery(criteriaQuery).getResultList();
        System.out.println(" employee6 tablosundaki maası 9000 den küçük veya  adı Sema olan Employee ler");
        resultList5.forEach(System.out::println);
        /*
        employee6 tablosundaki maası 9000 den küçük veya  adı Sema olan Employee ler

        Employee6{id=3, name='Sema', maas=7000}
        Employee6{id=5, name='Sema', maas=9000}
        Employee6{id=6, name='Sefa', maas=7000}
         */

        tx.commit();
        session.close();
        sf.close();

    }
}
