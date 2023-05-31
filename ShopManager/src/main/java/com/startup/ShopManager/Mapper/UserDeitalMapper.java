package com.startup.ShopManager.Mapper;

import com.startup.ShopManager.DTO.UserDeitalDTO;
import com.startup.ShopManager.Enum.Rankk;
import com.startup.ShopManager.entity.UserDeital;

public class UserDeitalMapper {
    public static UserDeital toUserDeital(UserDeitalDTO userDeitalDTO){
        UserDeital temp = new UserDeital();
        temp.setFirstName(userDeitalDTO.getFirstName());
        temp.setLastName(userDeitalDTO.getLastName());
        temp.setAddress(userDeitalDTO.getAddress());
        temp.setEmail(userDeitalDTO.getEmail());
        temp.setPhone(userDeitalDTO.getPhone());
        temp.setAccumulation(userDeitalDTO.getAccumulation());
        temp.setRankk(Rankk.BRONZE);
        return temp;
    }
}
