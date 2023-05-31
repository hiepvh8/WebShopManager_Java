package com.startup.ShopManager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.startup.ShopManager.Enum.Rankk;
import com.startup.ShopManager.Enum.Rankk;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userdeital")
public class UserDeital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "accumulation")
    private String accumulation;
    @Column(name = "rankk")
    @Enumerated
    private Rankk rankk;
    @OneToMany(mappedBy = "userDeital",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Voicher> voichers;
    @OneToOne(mappedBy = "userDeital")
    @JsonManagedReference
    private User user;

    public UserDeital(String firstName) {
        this.firstName = firstName;

    }
}
