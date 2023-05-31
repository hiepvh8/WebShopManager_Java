package com.startup.ShopManager.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.startup.ShopManager.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private Date date;
    @Column(name = "total")
    private String total;
    @Column(name = "status")
    @Enumerated
    private Status status;
    @OneToMany(mappedBy = "bill",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Product> products;
    @ManyToOne
    @JoinColumn(name = "userid",referencedColumnName = "id")
    @JsonManagedReference
    private User user;
}
