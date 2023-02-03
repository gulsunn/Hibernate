package Hibernate_Tekrar.OneToOne_ManyToOne.OnetoOne.Bi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DinnerCard1 {
    @Id
    private int id;
    private String name;

    @OneToOne
    @JoinColumn //İsteğe Bağlı mı????
    private Employee4 employee; // Bire bir ilişki kurduk   (Employee4 ile DinnerCard arasında) //Her işçinin bir yemek kartı olur

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

    public Employee4 getEmployee() {
        return employee;
    }

    public void setEmployee(Employee4 employee) {
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
