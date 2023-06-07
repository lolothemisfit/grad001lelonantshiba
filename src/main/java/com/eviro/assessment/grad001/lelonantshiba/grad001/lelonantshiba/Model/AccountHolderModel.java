package com.eviro.assessment.grad001.lelonantshiba.grad001.lelonantshiba.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "AccountProfile")
public class AccountHolderModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "AccountHolderName")
    private String name;

    @Column(name = "AccountHolderSurname")
    private String surname;

    @Column(name = "httpImageLink")
    private String httpImageLink;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setHttpImageLink(String httpImageLink) {
        this.httpImageLink = httpImageLink;
    }

    public String getHttpImageLink() {
        return httpImageLink;
    }

    @Override
    public String toString() {
        return "AccountHolderModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", httpImageLink='" + httpImageLink + '\'' +
                '}';
    }
}
