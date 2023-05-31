package com.startup.ShopManager.Request;

import com.startup.ShopManager.DTO.UserDTO;
import com.startup.ShopManager.DTO.UserDeitalDTO;
import lombok.Data;

@Data
public class UserRequestDTO {
    private UserDTO userDTO;
    private UserDeitalDTO userDeitalDTO;

    // constructors, getters and setters
}
