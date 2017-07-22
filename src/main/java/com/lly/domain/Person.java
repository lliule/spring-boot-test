package com.lly.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
@Entity
@NamedQuery(name = "Person.withNameAndAddressNameQuery",query = "select p from Person p where p.name=?1 and address =?2")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer age;
    private String address;

    public Person() {
    }

    public Person(Long id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
