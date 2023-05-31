package com.startup.ShopManager.serviceImp;

import com.startup.ShopManager.Exception.NotFoundException;
import com.startup.ShopManager.Mapper.UserDeitalMapper;
import com.startup.ShopManager.Mapper.UserMapper;
import com.startup.ShopManager.Request.UserRequestDTO;
import com.startup.ShopManager.entity.Cart;
import com.startup.ShopManager.entity.User;
import com.startup.ShopManager.entity.UserDeital;
import com.startup.ShopManager.repository.CartRepository;
import com.startup.ShopManager.repository.UserDeitalRepository;
import com.startup.ShopManager.repository.UserRepository;
import com.startup.ShopManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDeitalRepository userDeitalRepository;
    @Autowired
    CartRepository cartRepository;
    public UserServiceImp(UserRepository userRepository, UserDeitalRepository userDeitalRepository, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.userDeitalRepository = userDeitalRepository;
        this.cartRepository = cartRepository;
    }
    @Override
    public  void createUser(UserRequestDTO userRequestDTO){
        boolean flag = false;
        User user = UserMapper.toUser(userRequestDTO.getUserDTO());
        UserDeital userDeital = UserDeitalMapper.toUserDeital(userRequestDTO.getUserDeitalDTO());
        for (User users : userRepository.findAll()){
            if(users.getUsername().contains(user.getUsername())){
                flag = true;
            }
        }
        if (flag) {
            throw new RuntimeException("User đã tồn tại trong hệ thống!");
        }else {
            userDeitalRepository.save(userDeital);
            Cart cart = new Cart("0");
            cartRepository.save(cart);
            user.setUserDeital(userDeital);
            user.setCart(cart);
            userRepository.save(user);
        }
    }

    //Trả về danh sách User
    @Override
    public List<User> getAllUser(){
        List<User> users = userRepository.findAll();
        if(users.isEmpty()){
            throw new NotFoundException("Không có user nào trong hệ thống!");
        }else {
            return users;
        }
    }

    //Tìm Kiếm User theo id
    @Override
    public User getUserById(Long id){
       if(userRepository.findById(id).isPresent()) {
           return userRepository.findById(id).get();
       }
        throw new NotFoundException("User không tồn tại trong hệ thống!");
    }

    //Tim kiem User theo username(RequestParam)
    @Override
    public List<User> getUserByName(String keyword){
        List<User> users = new ArrayList<User>();
        for (User user : userRepository.findAll()) {
            //sử dụng giống equal
            if(user.getUsername().contains(keyword)){
                users.add(user);
            }else{
                throw new RuntimeException("Không có user có tên "+ keyword +" Trong Hệ thống!");
            }
        }
        return users;
    }
    @Override
    public void changePassword(Long id, String password){
        //Optional : không bắt buộc
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            // foundUser : người dùng được tìm thấy
            User foundUser = userRepository.findById(id).get();
            if(foundUser.getPassword().equals(password)){
                throw new RuntimeException("Mật khẩu của bạn đã được sử dụng, vui lòng đặt mật khẩu mới!");
            }else if(foundUser.getPassword().length() < 6){
                throw new RuntimeException("Độ dài của mật khẩu phải lớn hơn hoặc bằng 6 ký tự!");
            }else if (foundUser.getPassword().length() > 15){
                throw new RuntimeException("Độ dài của mật khẩu phải nhở hơn hoặc băng 15 ký tự!");
            }else{
                foundUser.setPassword(password);
                userRepository.save(foundUser);
            }
        }
    }
    @Override
    public void deleteUserById(Long id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }else {
            throw new RuntimeException("User không tồn tại trong hệ thống!");
        }
    }

}
