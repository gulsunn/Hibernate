package Hibernate_Tekrar.KullanıcıdanAlınanVerileriKaydetme2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
    @Id
    private int department_no;
    private String department_name;

    public int getDepartment_no() {
        return department_no;
    }

    public void setDepartment_no(int department_no) {
        this.department_no = department_no;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_no=" + department_no +
                ", department_name='" + department_name + '\'' +
                '}';
    }
}
