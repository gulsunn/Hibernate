package Hibernate_Tekrar.IDGenerator_CriteriaApi;

import javax.persistence.*;

@Entity
public class Employee6 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int maas;

    public Employee6() {
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

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public Employee6(Long id, String name, int maas) {
        this.id = id;
        this.name = name;
        this.maas = maas;
    }

    @Override
    public String toString() {
        return "Employee6{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maas=" + maas +
                '}';
    }
}
