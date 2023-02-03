package Hibernate_Tekrar.OneToOne_ManyToOne.OnetoOne.Bi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee4 {
    @Id
    private int id;
    private String name;
    private int salary;

    @OneToOne(mappedBy = "employee")
    private DinnerCard1 dinnerCard;  //İlişkikin çift yönlü olöası için Employee4 Classınd dinnerCard fiel ekledik

    public DinnerCard1 getDinnerCard() {  //Sonradan ekledim Employeeden de dinner carda ulaşabilmek için
        return dinnerCard;
    }

    //DinnerCard için setter methodunu eklemedik çünkü ilişkinin asıl sahibi Dinner Card olduğu için
    // employee üzerinden  yemek kartı(dinner card) set leme işi yaparsak null gelir

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

