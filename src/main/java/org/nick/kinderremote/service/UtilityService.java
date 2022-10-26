package org.nick.kinderremote.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nick.kinderremote.data.dto.HtRequest;
import org.nick.kinderremote.data.entity.Product;
import org.nick.kinderremote.repository.ManufacturerRepository;
import org.nick.kinderremote.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class UtilityService {
    @Autowired
    CatService cs;
    @Autowired
    ProdService ps;
    @Autowired
    ManufacturerRepository manRepo;
    @Autowired
    ProductRepository prodRepo;


    public String getInitialData() throws IOException, ClassNotFoundException {
        String initialProductsList = ps.getInitialProductsList(new HtRequest());
        String catalog = cs.getAll(new HtRequest());
        return null;
    }
    public String createInitialProductIdSet(HtRequest request) throws IOException {
        Set <Long> productsIdSet = prodRepo.getAllProductId();
        FileOutputStream fos = new FileOutputStream("ProductTotalId.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(productsIdSet);
        oos.close();
        return "createInitialProductIdSet is performed";
    }

    public String createRandomizedProductSet(HtRequest request) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("ProductTotalId.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);

        List<Long> totalProductsIdList = new ArrayList((Set<Long>) ois.readObject());
        ois.close();
        ArrayList<Integer> idInts = new ArrayList<>();

        //        безымянный объект Рандома, генерящий (в данном случае Интовый) поток цыфр (мощность потока, стартовое знч, максимальное), через форИч пихуемый в ранеесозданный Лист
        new Random().ints(15, 0, (totalProductsIdList.size() -1)).forEach(idInts::add);
//        new Random().ints(15, 0, (totalProductsIdList.size() -1)).forEach(idInts::add);

        List<Long>productsIdSearchList = new ArrayList<>();

            for (Integer idInt : idInts) {
                productsIdSearchList.add(totalProductsIdList.get(idInt));
                System.out.println("idNumber in List " + idInt + " corresponding Product Id " + totalProductsIdList.get(idInt));
            }
        //TODO вместо findAll поштучно извлечь кастомной кверью
        List<Product> allProductsById = prodRepo.findAllById(productsIdSearchList);
        ObjectMapper mapper = new ObjectMapper();
            mapper.findAndRegisterModules(); //Нужно для обработки даты создания...

        return mapper.writeValueAsString(allProductsById);
    }
//    =======Trash from^==========
    //        return productsIdSearchList.toString();
    //          Вариант Рандома
    //        IntStream ints1 = ThreadLocalRandom.current().ints(10, 0, 101);
    ////        new Random().ints(num, origin, bound)
    //        IntStream ints2 = new Random().ints(10, 0, idSetSize);
    //        IntStream ints2 = new Random().ints(10, 0, 100);

    //        return "ProductsListRandomed";
//    =======EndOfTrash from^==========


}
