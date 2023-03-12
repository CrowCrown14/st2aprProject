package com.st2apr.project.st2aprproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tutor", schema = "st2aprProject", catalog = "")
public class TutorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    @Basic
    @Column(name = "tutorFirstName", nullable = false, length = 50)
    private String tutorFirstName;
    @Basic
    @Column(name = "tutorLastName", nullable = false, length = 50)
    private String tutorLastName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTutorFirstName() {
        return tutorFirstName;
    }

    public void setTutorFirstName(String tutorFirstName) {
        this.tutorFirstName = tutorFirstName;
    }

    public String getTutorLastName() {
        return tutorLastName;
    }

    public void setTutorLastName(String tutorLastName) {
        this.tutorLastName = tutorLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TutorEntity entity = (TutorEntity) o;

        if (username != null ? !username.equals(entity.username) : entity.username != null) return false;
        if (password != null ? !password.equals(entity.password) : entity.password != null) return false;
        if (tutorFirstName != null ? !tutorFirstName.equals(entity.tutorFirstName) : entity.tutorFirstName != null)
            return false;
        if (tutorLastName != null ? !tutorLastName.equals(entity.tutorLastName) : entity.tutorLastName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (tutorFirstName != null ? tutorFirstName.hashCode() : 0);
        result = 31 * result + (tutorLastName != null ? tutorLastName.hashCode() : 0);
        return result;
    }
}
