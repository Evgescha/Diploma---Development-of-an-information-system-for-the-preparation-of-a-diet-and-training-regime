package com.hescha.trainingdaily.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "myUsers")
@Data
public class User extends AbstractEntity {

    @Column(unique = true)
    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String fio;

    @NotNull
    private String email;

    @NotNull
    private Date dateBorn;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "addedBy", fetch = FetchType.LAZY)
    private List<Product> suggestedFoods = new ArrayList<>();

    @OneToMany(mappedBy = "addedBy", fetch = FetchType.LAZY)
    private List<Exercise> suggestedExercises = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<DailyRoutine> dailyRoutines = new TreeSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(fio, user.fio) && Objects.equals(email, user.email) && Objects.equals(dateBorn, user.dateBorn) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username, password, fio, email, dateBorn, role);
    }
}
