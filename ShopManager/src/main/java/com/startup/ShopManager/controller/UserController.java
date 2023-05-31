package com.startup.ShopManager.controller;

import com.startup.ShopManager.Request.UserRequestDTO;
import com.startup.ShopManager.entity.User;
import com.startup.ShopManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private  UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Trả Về List user
    //http://localhost:8080/users
    @GetMapping("")
    public ResponseEntity<?> gettAllUser(){
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    //Trả về user theo id
    //Sử dụng pathviriable
    //http://localhost:8080/users/2
    @GetMapping("/{id}")
    public ResponseEntity<? > getUserById(@PathVariable Long  id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    //http://localhost:8080/users/search?keyword=hiep
    @GetMapping("/search")
    public ResponseEntity< ? > getUserByName(@RequestParam(name="keyword", required = false, defaultValue = "") String name) {
        List<User> users = userService.getUserByName(name);
        return ResponseEntity.ok(users);
    }
    //Thêm người dùng
//    {
//        "userDTO":{
//        "username":"hello",
//                "password":"1234"
//    },"userDeitalDTO":{
//        "firstName":"hiep",
//                "lastName":"vu",
//                "address":"Ha Nam",
//                "email":"hiepvu01082002@gmail.com",
//                "phone":"0912100333",
//                "accumulation":"1"
//    }
//    }
    @PostMapping("/register")
    public ResponseEntity<? > createUser(@RequestBody UserRequestDTO userRequestDTO){
        userService.createUser(userRequestDTO);
        return new ResponseEntity<>("Thêm thành công!",HttpStatus.CREATED);
    }
    @PutMapping("/{id}/change-to-password")
    public ResponseEntity<?> updatePassword(@PathVariable("id") Long id, @RequestParam("new_password") String password){
        userService.changePassword(id,password);
        return ResponseEntity.ok("Thành công!");
    }
    @DeleteMapping("/{id}/delete-user")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("Thành công!");
    }
}
