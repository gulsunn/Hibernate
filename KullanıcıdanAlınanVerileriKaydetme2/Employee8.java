package Hibernate_Tekrar.KullanıcıdanAlınanVerileriKaydetme2;

import javax.persistence.*;

@Entity
public class Employee8 {
    //Fields id,name,salary,department_no

    @Id  //id fieldı primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id ler otomatik verilsin (elle değil)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int salary;
    @ManyToOne  // İlişki türü (one:tek taraflı)
    @JoinColumn
    private Department department;

    //Constructors

    public Employee8() {
    }

    public Employee8(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    //Getter and Setters

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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



    //To String

    @Override
    public String toString() {
        return "Employee7{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
