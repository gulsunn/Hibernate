package com.hb01.annotation;

import javax.persistence.*;

/*
Bu Class database ile konuşacak Class hibernate aracılığı ile
Bunu belirtmek için @Entity annotation yazarız
@Entity annotation ı koyduğumuz sınıfı(Student01) DB de bir tabloya karşılık getirir.
@Entity bir  annotationdur ve içindeki kodları Class'a dahil ederiz(Burada tekrar yazmamıza gerek kalmaz)

 */
@Entity
@Table(name="t_student01") //DB'de tablo ismi "t_student01" olarak değişti (Bunu yazmazsak tablo adı Class adının küçük harfli hali olur.(student01)
public class Student01 {  //DB'de "student01" isminde bir tablo oluşturur

    // @Column(name="std_id")
    @Id  // @Id : primary key oluşmasını sağlar
    private int id;

    // @Column zorunlu değil ancak customize edebilmek için gerekli
    @Column(name="student_name", length = 100 , nullable = false, unique = false) // unique false yazmasak da olur varsayılaı false zaten
    private  String name;

    // @Transient //DB'deki tabloda "grade" adında bir column oluşmasını engeller. (Bazı bilgiler database'e gitmesini istemediğimiz zaman)
    private int grade;

    // @Lob // large object ile büyük boyutlu datalar tutulabilir (Big Data'nın databasee gelmek üzere olduğunu anlatmak için)
    //private byte[] image;  //image dosyalaru büyük boyuttadır



    // Getter-Setter *****************

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}

/*
  Pojo Class
 private Fields
 Constructors
 getter setters
 To String
 */

/*
Hibernate:

    create table t_student01 (
       id int4 not null,
        grade int4 not null,
        student_name varchar(100) not null,
        primary key (id)
    )


 */
/*
Hibernate:
    insert
    into
        t_student01
        (grade, student_name, id)
    values
        (?, ?, ?)
 */
