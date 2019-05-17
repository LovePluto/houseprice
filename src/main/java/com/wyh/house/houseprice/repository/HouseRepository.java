package com.wyh.house.houseprice.repository;

import com.wyh.house.houseprice.po.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    @Query("select distinct h.communityName from House h")
    List<String> findDistinctByCommunityName();
}
