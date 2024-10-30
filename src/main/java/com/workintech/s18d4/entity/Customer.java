package com.workintech.s18d4.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer" , schema = "fsweb")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "salary")
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id" , referencedColumnName = "id")
    private Address address;


    @JsonIgnore
    @OneToMany(mappedBy="customer")
    private List<Account> account;


    public void addAccount(Account account){
        if(this.account == null){
            this.account=new ArrayList<>();
        }
        this.account.add(account);
    }

    public List<Account> getAccounts() {
        return account;
    }

    public void setAccounts(List<Account> account) {
        this.account = account;
    }
}
