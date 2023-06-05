package com.solovev.simplecrmfx.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.*;

public class User {
    @JsonAlias("ID")
    private int id;

    private String name;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss",
            shape = JsonFormat.Shape.STRING)
    @JsonAlias("regDate")
    private LocalDateTime registrationDate;

    private String email;

    private int age;

    private String country;

    @JsonIgnore
    private boolean isSend;

    public User() {
    }

    public User(int id, String name, LocalDateTime registrationDate, String email, int age, String country, boolean isSend) {
        this.id = id;
        this.name = name;
        this.registrationDate = registrationDate;
        this.email = email;
        this.age = age;
        this.country = country;
        this.isSend = isSend;
    }

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

    public boolean getIsSend() {
        return isSend;
    }

    public void setIsSend(boolean send) {
        isSend = send;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
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
        int result = id;
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
                "ID=" + id +
                ", name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", isSend=" + isSend +
                '}';
    }
}
