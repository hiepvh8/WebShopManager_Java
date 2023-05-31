package com.startup.ShopManager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.startup.ShopManager.DTO.UserDTO;
import com.startup.ShopManager.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
//implements UserDetails
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "enable")
    private String enable;
    @Column(name = "role")
    @Enumerated
    private Role role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userdeitalid",referencedColumnName = "id")
    @JsonManagedReference
    @JsonIgnore
    private UserDeital userDeital;
    @OneToOne
    @JoinColumn(name = "cartid",referencedColumnName = "id")
    @JsonManagedReference
    @JsonIgnore // Tránh lặp lại bỏ qua các thuộc tính không cần thiết
    private Cart cart;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Bill> bills;
    public User(UserDTO userDTO){
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
        this.enable   = "1";
        this.role     = Role.USER;
    }
    public User(String username,String password,String enable,Role role){
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.role = role;
    }
    public User(String username) {
        this.username = username;

    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
}
