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
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "text")
    private String text;
    @Column(name = "vote")
    private Long Vote;
    @ManyToOne
    @JoinColumn(name = "productid",referencedColumnName = "id")
    @JsonManagedReference
    private Product product;
    @ManyToOne
    @JoinColumn(name = "userid",referencedColumnName = "id")
    @JsonManagedReference
    private User user;
}
