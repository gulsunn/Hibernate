package Hibernate_Tekrar.KullanıcıdanAlınanVerileriKaydetme1;

import Hibernate_Tekrar.KullanıcıdanAlınanVerileriKaydetme2.Department;

import javax.persistence.*;

@Entity
public class Employee7 {
    //Fields id,name,salary,department_no

    @Id  //id fieldı primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id ler otomatik verilsin (elle değil)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int salary;

    private int department_no;

    //Constructors

    public Employee7() {
    }

    public Employee7(String name, int salary,int department_no) {
        this.name = name;
        this.salary = salary;
        this.department_no=department_no;
    }

    //Getter and Setters


    public int getDepartment_no() {
        return department_no;
    }

    public void setDepartment_no(int department_no) {
        this.department_no = department_no;
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
                ", department_no=" + department_no +
                '}';
    }
}

