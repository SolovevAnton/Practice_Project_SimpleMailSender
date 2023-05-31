package com.solovev.simplecrmfx.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
    private int ID;
    private String name;
    private LocalDateTime registrationDate;
    private String email;
    private int age;
    private String country;
    @JsonIgnore
    private boolean isSend;

    public User() {
    }

    public User(int ID, String name, LocalDateTime registrationDate, String email, int age, String country, boolean isSend) {
        this.ID = ID;
        this.name = name;
        this.registrationDate = registrationDate;
        this.email = email;
        this.age = age;
        this.country = country;
        this.isSend = isSend;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (ID != user.ID) return false;
        if (age != user.age) return false;
        if (isSend != user.isSend) return false;
        if (!Objects.equals(name, user.name)) return false;
        if (!Objects.equals(registrationDate, user.registrationDate))
            return false;
        if (!Objects.equals(email, user.email)) return false;
        return Objects.equals(country, user.country);
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (isSend ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", isSend=" + isSend +
                '}';
    }
}
