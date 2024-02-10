package org.nick.kinderremote.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/authority", produces = "application/json")
public class AuthorityController {

    @PostMapping("/noname")
    public String authority(@RequestParam("localSessionId") String sessionId){
        System.out.println("===============AUTHORYTHY================");
        System.out.println(sessionId);
        return null;
    }

}
