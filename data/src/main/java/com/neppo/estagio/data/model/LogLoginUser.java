package com.neppo.estagio.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="log_login_user")
public class LogLoginUser {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;

    @ManyToOne
    User user;

    Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "LogLoginUser{" +
                "id=" + id +
                ", user=" + user +
                ", date=" + date +
                '}';
    }
}
