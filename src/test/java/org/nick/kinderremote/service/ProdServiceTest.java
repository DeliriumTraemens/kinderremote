package org.nick.kinderremote.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nick.kinderremote.data.dto.HtRequest;
import org.nick.kinderremote.data.entity.Product;
import org.nick.kinderremote.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationTargetException;
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

    @Autowired
    MainService mainService;

    @Autowired
    ApplicationContext context;

    private Gson gson;
    private HtRequest request;

//    @BeforeEach
//    void gsonSetup(){
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    }
    @BeforeEach
    void setUp() {
      gson = new GsonBuilder().setPrettyPrinting().create();
      request=new HtRequest();
    }

    @Test
    void mainServiceGetProductByIdTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, JsonProcessingException {
        request.setServiceName("ProdService");
        request.setMethodName("findProductById");
        request.setProdId(132948L);

        Object dispatcher =  mainService.dispatcher(request);
        assertNotNull(dispatcher);
        System.out.println("===============Test result 1==================");
        System.out.println(dispatcher);

    }

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
//        request.setProdId(132948L);
//        Product productById = prodService.findProductById(request);
//        Product productById = prodService.findProductById(request);
//        assertNotNull(productById);
//        assertTrue(productById instanceof Product);
//        assertTrue(productById.getManufacturer() instanceof Manufacturer);
//        System.out.println(productById);
    }

    //========================
    @Test
    void testFindProductByIdWithHtRequest() throws JsonProcessingException {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();

//        HtRequest request = new HtRequest();
//        request.setProdId(132948L);
//        Product productById = prodService.findProductById(request);
//        assertNotNull(productById);
//        assertTrue(productById instanceof Product);
//        String productJson = gson.toJson(productById);
//        System.out.println(productJson);

    }

    @Test
    void testFindById(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Optional<Product> byId = prodRepo.findById(132948L);
        assertNotNull(byId);
        Product product = byId.get();
        String s = gson.toJson(product);
        System.out.println(s);
    }

}