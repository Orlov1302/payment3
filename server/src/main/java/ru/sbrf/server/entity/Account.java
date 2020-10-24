package ru.sbrf.server.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "Accounts")
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private String number;
    private int balance;

    public Account() {
        this.id = new Long(0);
        this.number = "";
        this.balance = 0;
    }
}

////