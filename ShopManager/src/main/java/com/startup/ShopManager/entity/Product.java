package com.startup.ShopManager.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "productname")
    private String productName;
    @Column(name = "firstDay")
    private LocalDate firstDate;
    @Column(name = "count")
    private String count;
    @Column(name = "introduce")
    private String introduce;
    @Column(name = "vote")
    private Long vote;
    @Column(name = "discount")
    private String discount;
    @ManyToMany(mappedBy = "products")
    @JsonManagedReference
    private Set<Cart> carts;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;
    @ManyToOne
    @JoinColumn(name = "categoryid",referencedColumnName = "id")
    @JsonManagedReference
    private Category category;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Image> images;
    @ManyToOne
    @JoinColumn(name = "billid",referencedColumnName = "id")
    @JsonManagedReference
    private Bill bill;

}
