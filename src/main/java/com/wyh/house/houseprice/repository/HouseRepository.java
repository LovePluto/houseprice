package com.wyh.house.houseprice.repository;

import com.wyh.house.houseprice.po.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
}
