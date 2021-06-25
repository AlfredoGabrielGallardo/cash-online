package com.cashonline.apirest.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "loans")
public class Loan implements Serializable {

//    Attributes/Column:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private BigDecimal total;

//    Relations:
    @ManyToOne
    @JsonIgnoreProperties(value = "loan")
    @JoinColumn(name="user_id",nullable = false)
    private User user ;


//    Builders:
    public Loan() {
    }

    public Loan(User user, BigDecimal total) {
        this.user = user;
        this.total = total;
    }

//    Getter and Setter:

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    private static final long serialVersionUID = 1L;

}


