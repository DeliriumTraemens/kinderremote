package org.nick.kinderremote.controller;

import org.nick.kinderremote.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/authority", produces = "application/json")
public class AuthorityController {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    AuthenticationService authService;

    @PostMapping("/noname")
    public String authority(@RequestParam("localSessionId") String sessionId, HttpServletRequest request){
        printSessionId(sessionId, request);

        printParametersMap(request);

        printRequestDetails(request);


        String authorityToSend=authService.processAuthorisation(sessionId,request);

        return authorityToSend;
    }

    public void printRequestDetails(HttpServletRequest request) {
        System.out.println("Method: " + request.getMethod());
        System.out.println("Request URI: " + request.getRequestURI());
        System.out.println("Headers: " + request.getHeaderNames());
        Enumeration<String> headerNames = request.getHeaderNames();
        System.out.println("=====HEADERS======");
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName + ": " + headerValue);
        }

        System.out.println("Parameters: " + request.getParameterMap());
        System.out.println("Cookies: " + request.getCookies());
        System.out.println("...");
    }

    public void printParametersMap(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String paramName = entry.getKey();
            String[] paramValues = entry.getValue();
            System.out.println(paramName + ": " + Arrays.toString(paramValues));
        }
        System.out.println();
    }

    public void printSessionId(@RequestParam("localSessionId") String sessionId, HttpServletRequest request) {
        System.out.println("===============AUTHORYTHY================");
        System.out.println(sessionId);
        System.out.println("==========------------REQUEST-----------============");
        System.out.println(request.toString());
    }

}
