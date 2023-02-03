package Hibernate_Tekrar.OneToOne_ManyToOne.ManytoOne;

import javax.persistence.*;

@Entity
public class Employee5 {
    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    private int salary;
    @ManyToOne
    @JoinColumn
    private Transporter transporter; //ManyToOne ilişki kurduk bir servise birden fazla Employee binebilir.(Many:Employee One :Transporter İlişki Sahibi Employee)

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

    public Transporter getTransporter() {
        return transporter;
    }

    public void setTransporter(Transporter transporter) {
        this.transporter = transporter;
    }

    @Override
    public String toString() {
        return "Employee05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", transporter=" + transporter +
                '}';
    }
}
