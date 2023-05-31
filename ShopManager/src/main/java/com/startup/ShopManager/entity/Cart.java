package com.startup.ShopManager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne(mappedBy = "cart")
    @JsonManagedReference
    private User user;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cart_product",
            joinColumns = @JoinColumn(name = "cartid"),
            inverseJoinColumns = @JoinColumn(name = "productid"))
    @JsonManagedReference
    private List<Product> products;
    private String total;
    public Cart(String total){
        this.total = total; // khởi tạo giỏ hàng Tổng tiền 0 đ;
    }
}
