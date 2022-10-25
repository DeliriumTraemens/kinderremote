package org.nick.kinderremote.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.nick.kinderremote.data.dto.HtRequest;
import org.nick.kinderremote.data.dto.InputData;
import org.nick.kinderremote.service.MainService;
import org.nick.kinderremote.util.state.CatalogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/", produces = "application/json")
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    CatalogUtil cu;
    @Autowired
    MainService ms;

    @GetMapping
    public Object mainEndPoint(HtRequest request, HttpServletResponse response) throws JsonProcessingException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Cookie cookie = new Cookie("username", "Johannnan");
        Cookie cookie1 = new Cookie("username1", "Grigorich");

        response.addCookie(cookie);
        response.addCookie(cookie1);

        logger.info("mainEndPoint Requested");


        return ms.dispatcher(request);
    }



    //Test and Service

    @GetMapping("/catalog")
    public String getCatalog() throws IOException, ClassNotFoundException {
        String catalog = cu.getStringCatalogFromFile();
        return catalog;
    }

    @GetMapping("/makeCat")
    public String makeCatalog() throws IOException {
       cu.makeCatalog();
       return "Catalog maker isDone";
    }

    @GetMapping("/d2")
    public String getData2(InputData data){
        logger.info("org.nick.kinderremote.controller.MainController.getData2 requested");
        return data.toString();
    }

//    @GetMapping("/prodCatId")
//    public String getProdByCatId(HtRequest request){
//        return ms.getProdByCatId(request);
//    }

    @PostMapping("/data")
    public String resultData(InputData data){
        return data.toString();
    }





}
