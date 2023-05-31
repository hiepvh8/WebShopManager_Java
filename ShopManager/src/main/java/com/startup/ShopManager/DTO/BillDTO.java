package com.startup.ShopManager.DTO;

import com.startup.ShopManager.Enum.Status;
import lombok.Data;

import java.util.Date;

@Data
public class BillDTO {
    private Date date;
    private String total;
    private Status status;

}
