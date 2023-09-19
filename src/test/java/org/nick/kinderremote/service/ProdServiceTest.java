package org.nick.kinderremote.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.nick.kinderremote.data.dto.HtRequest;
import org.nick.kinderremote.data.entity.Manufacturer;
import org.nick.kinderremote.data.entity.Product;
import org.nick.kinderremote.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        List<Long> ids = new ArrayList<>(Arrays.asList(132948L));
        List<Product> byId = prodRepo.findAllById(ids);
//        System.out.println(product);
        for (Product product : byId) {
            System.out.println("\n" + product);
        }
    }

    @Test
    void findProductById() {
        Optional<Product> productById = prodRepo.findProductById(132948L);
        assertNotNull(productById);
        System.out.println(productById);
        Product product = productById.get();
        assertNotNull(product);
        assertTrue(product instanceof Product);
    }


    @Test
    void testFindProductById() {
        Product productById = prodService.findProductById(132948L);
        assertNotNull(productById);
        assertTrue(productById instanceof Product);
        assertTrue(productById.getManufacturer() instanceof Manufacturer);
        System.out.println(productById);
    }
    @Test
    void testFindProductByIdWithHtRequest() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        HtRequest request = new HtRequest();
        request.setProdId(132948L);
        Product productById = prodService.findProductById(request.getProdId());
        assertNotNull(productById);
        assertTrue(productById instanceof Product);
        String productAsString = mapper.writeValueAsString(productById);
        System.out.println(productAsString);

    }

}