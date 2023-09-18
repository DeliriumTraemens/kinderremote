package org.nick.kinderremote.service;

import org.junit.jupiter.api.Test;
import org.nick.kinderremote.data.entity.Product;
import org.nick.kinderremote.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
//@DataJpaTest
//@RunWith(SpringRunner.class)
class ProdServiceTest {

    @Autowired
    ProdService prodService;
    @Autowired
    ProductRepository prodRepo;

    @Test
    void getById() {
        List<Long>ids=new ArrayList<>(Arrays.asList(132948L));
        List<Product> byId = prodRepo.findAllById(ids);
//        System.out.println(product);
        System.out.println(byId);

    }
}