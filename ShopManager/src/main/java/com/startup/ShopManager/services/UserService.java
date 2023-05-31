package com.startup.ShopManager.services;

import com.startup.ShopManager.Request.UserRequestDTO;
import com.startup.ShopManager.entity.User;

import java.util.List;

public interface UserService {

    //Trả về danh sách user
    public List<User> getAllUser();

    //Trả về user theo id
    User getUserById(Long id);

    //Tạo 1 user
    void createUser(UserRequestDTO userRequestDTO);

    //Trả về danh sách user theo name
    public List<User> getUserByName(String keyword);

    //Thay đổi mật khẩu
    public void changePassword(Long id, String password);

    public void deleteUserById(Long id);
}
