package Hibernate_Tekrar.OneToOne_ManyToOne.OnetoOne.Uni;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DinnerCard {
    @Id
    private int id;
    private String name;

    @OneToOne
    @JoinColumn //İsteğe Bağlı mı????
    private Employee3 employee; // Bire bir ilişki kurduk   (Employee3 ile DinnerCard arasında) //Her işçinin bir yemek kartı olur

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

    public Employee3 getEmployee() {
        return employee;
    }

    public void setEmployee(Employee3 employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "DinnerCard{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", employee=" + employee +
                '}';
    }
}
