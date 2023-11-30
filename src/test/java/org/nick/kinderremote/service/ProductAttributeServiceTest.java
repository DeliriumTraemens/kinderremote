package org.nick.kinderremote.service;

import org.junit.jupiter.api.Test;
import org.nick.kinderremote.data.dto.ProductDetailsDto;
import org.nick.kinderremote.data.entity.Product;
import org.nick.kinderremote.data.entity.ProductAttributeMain;
import org.nick.kinderremote.repository.ProductAttributeRepository;
import org.nick.kinderremote.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductAttributeServiceTest {
//@Autowired
//ProductAttributeService pas;
@Autowired
ProdService ps;
@Autowired
    ProductRepository pr;

    @Autowired
    ProductAttributeRepository pa;

    @Autowired
    ProductAttributeService pas;

    @Test
    void productWithAttributeDtoTest(){
        Long prodId = 265000L;
        Product productById = pr.findProductById(prodId).get();
        List<ProductAttributeMain> paById = pas.findPAById(prodId);
        Object attribDto = pas.convertToDto(paById);
        ProductDetailsDto productDetailsDto = ps.generateProductDto(productById, attribDto);
        System.out.println(productDetailsDto);
    }

    @Test
    void firstRepoTest(){
        Long prodId = 265000L;
//        ProductAttributeKey key = new ProductAttributeKey();
//        key.setProdId(prodId);
        List<ProductAttributeMain> prAttr= pa.findByKeyProductId(prodId);
        assertNotNull(prAttr);
        System.out.println(prAttr);
    }

    @Test
    void secondRepoTest(){
        Long prodId = 265000L;
        List<ProductAttributeMain> paById = pas.findPAById(prodId);
        System.out.println(paById);
    }

    @Test
    void prodAtrServiceConvertToDto1(){
        Long prodId = 265000L;
        List<ProductAttributeMain> paById = pas.findPAById(prodId);
        Object o = pas.convertToDto(paById);
        System.out.println(o);
    }


//    @Test
//    void findPAByIdTest() {
////        List<ProductAttributeMain> result = pas.findPAById();
////        assertNotNull(result);
//    }
}