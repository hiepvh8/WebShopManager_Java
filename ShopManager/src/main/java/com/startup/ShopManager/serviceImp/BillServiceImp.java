package com.startup.ShopManager.serviceImp;

import com.startup.ShopManager.repository.BillRepository;
import com.startup.ShopManager.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImp implements BillService {
    @Autowired
    BillRepository billRepository;
}
