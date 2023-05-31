package com.startup.ShopManager.controller;

import com.startup.ShopManager.DTO.UserDTO;
import com.startup.ShopManager.entity.User;
import com.startup.ShopManager.entity.UserDeital;
import com.startup.ShopManager.services.UserDeitalService;
import com.startup.ShopManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userDeitals")
public class UserDeitalController {
    @Autowired
    private UserDeitalService userDeitalService;

//    @GetMapping("")
//    public ResponseEntity<?> gettAllUserDeital(){
//        List<UserDeital> userDeitals = userDeitalService.getAllUserDeital();
//        return ResponseEntity.ok(userDeitals);
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getUserDeitalById(@PathVariable("id") Long id){
//
//    }
//    @PostMapping("/register")
//    public ResponseEntity<? > createUserDeital(){
//        userDeitalService.createUserDeital();
//        return new ResponseEntity<>("Thêm thành công!", HttpStatus.CREATED);
//    }

}
