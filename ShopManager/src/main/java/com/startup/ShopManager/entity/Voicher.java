package com.startup.ShopManager.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "voicher")
public class Voicher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "voicherName")
    private String voicherName;
    @Column(name = "reductionPrice")
    private String reductionPrice;
    @ManyToOne
    @JoinColumn(name = "userDeitalid",referencedColumnName = "id")
    @JsonManagedReference
    private UserDeital userDeital;
}
