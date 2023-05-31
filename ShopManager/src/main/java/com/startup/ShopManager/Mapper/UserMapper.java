package com.startup.ShopManager.Mapper;

import com.startup.ShopManager.DTO.UserDTO;
import com.startup.ShopManager.Enum.Role;
import com.startup.ShopManager.entity.User;
import lombok.Data;

@Data
public class UserMapper {
    public static UserDTO toUserDTO(User user){
        UserDTO temp = new UserDTO();
        temp.setUsername(user.getUsername());
        temp.setPassword(user.getPassword());

        return temp;
    }
    public static User toUser(UserDTO userDTO){
        User temp = new User();
        temp.setUsername(userDTO.getUsername());
        temp.setPassword(userDTO.getPassword());
        temp.setEnable("1");
        temp.setRole(Role.USER);
        return temp;
    }
}
