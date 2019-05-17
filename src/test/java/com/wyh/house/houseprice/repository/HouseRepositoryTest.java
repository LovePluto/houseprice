package com.wyh.house.houseprice.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class HouseRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private HouseRepository houseRepository;

    @Test
    public void getCommunityNameByDistinct() {
        List<String> name = houseRepository.findDistinctByCommunityName();
        System.out.println(name);
        System.out.println(name.size());
    }
}