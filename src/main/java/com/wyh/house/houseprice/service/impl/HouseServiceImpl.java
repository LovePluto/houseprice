package com.wyh.house.houseprice.service.impl;

import com.wyh.house.houseprice.po.House;
import com.wyh.house.houseprice.repository.HouseRepository;
import com.wyh.house.houseprice.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepository houseRepository;

    @Override
    public List<House> getAll() {
        return houseRepository.findAll();
    }
}
