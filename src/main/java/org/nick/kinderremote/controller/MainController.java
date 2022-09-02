package org.nick.kinderremote.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.nick.kinderremote.data.dto.HtRequest;
import org.nick.kinderremote.data.dto.InputData;
import org.nick.kinderremote.data.entity.Catalog;
import org.nick.kinderremote.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class MainController {
@Autowired
    MainService ms;
//    @Autowired
//    public MainController(MainService ms) {
//        this.ms = ms;
//    }

    @GetMapping
    public String mainEndPoint(HtRequest request) throws JsonProcessingException {
        return ms.dispatcher(request);
    }

//    @GetMapping
//    public String getData(@RequestParam("type")String type, @RequestParam(required=false, name="id")Long id ) throws JsonProcessingException {
//        return ms.getResponce(type);
//    }

    @GetMapping("/d2")
    public String getData2(InputData data){
        return data.toString();
    }


    @PostMapping("/data")
    public String resultData(InputData data){
        return data.toString();
    }

//    @PostMapping("/data2")
//    public String resultData2(@RequestParam("id")String id, @RequestParam("header") String header) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        String result = mapper.writeValueAsString(new InputData(id,header,status,));
//        return result;
//    }

    @GetMapping("/cat")
    public Catalog catalog(){
        return ms.catalog();
    }

}
