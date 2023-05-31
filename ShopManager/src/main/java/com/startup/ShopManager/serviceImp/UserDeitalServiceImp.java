package com.startup.ShopManager.serviceImp;

import com.startup.ShopManager.entity.User;
import com.startup.ShopManager.entity.UserDeital;
import com.startup.ShopManager.repository.UserDeitalRepository;
import com.startup.ShopManager.services.UserDeitalService;
import com.startup.ShopManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDeitalServiceImp implements UserDeitalService {
    @Autowired
    UserDeitalRepository userDeitalRepository;


    @Override
    public void createUserDeital() {
        UserDeital userDeital = new UserDeital("cong");
        userDeitalRepository.save(userDeital);
    }
    @Override
    public List<UserDeital> getAllUserDeital(){
        return userDeitalRepository.findAll();
    }
}
