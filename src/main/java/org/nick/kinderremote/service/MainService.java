package org.nick.kinderremote.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nick.kinderremote.data.dto.HtRequest;
import org.nick.kinderremote.data.entity.Catalog;
import org.nick.kinderremote.util.ActionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class MainService {

    private final CategoryService catServ;
    ObjectMapper objectMaper;

    ActionRegistry<Function>registry=new ActionRegistry<>();

    @Autowired
    public MainService(CategoryService catServ) {
        this.catServ = catServ;


    }

    public String getResponce(String type) throws JsonProcessingException {
        Map<String, Supplier<String>>map=new HashMap<>();
//        FuncSuplier<String>func=catServ::getAllCatalog;
        map.put("catalog", catServ::getAllCatalog);
        map.put("progulki", catServ::getCatalog2);
        map.put("razvitie", catServ::getRazvitie);

        Supplier<String> runn = catServ::getAllCatalog;
        Supplier<String> progulkiDoma = catServ::getCatalog2;

        String responce="Unknown";

        return map.get(type).get();

//        switch (type){
////            case "cat": responce= catServ.getAllCatalog();
////            case "cater": responce=runn.get();
//            case "cater": return runn.get();
////                break;
////            case "cat2": responce=catServ.getCatalog2();
//            case "cat2": return progulkiDoma.get();
////                break;
//            case "prod": responce= "Product";
//                break;
//            default: responce = "Unknown type";
//                break;
//        }
//        return responce;
    }

//    public void populateRegistry(Long id){
//        this.registry.add("FindAll",this::findById());
//    }

    public  String findAll(){


        return "Find All Service method";
    }

    public String findById(Long Id){
        return "Found By Id";
    }

    public Catalog catalog() {
        return catServ.catalog();
    }

    public String dispatcher(HtRequest request) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
        /**
         * Получить класс, метод
         * Инвок с аргументами
         * Сформировать и вернуть строковый Джейсонированный Респонс
         * */

        return new ObjectMapper().writeValueAsString(request);
    }
}
