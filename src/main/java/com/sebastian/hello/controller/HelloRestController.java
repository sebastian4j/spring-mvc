package com.sebastian.hello.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sebastian.hello.modelo.Saludo;
import com.sebastian.hello.repo.EmpresaRepo;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    private static final Logger LOGGER = LogManager.getLogger(HelloRestController.class);
    @Autowired
    private EmpresaRepo erepo;
    
    @RequestMapping(value = "/saludar", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)    
    public @ResponseBody Saludo saludar(@RequestHeader HttpHeaders headers) {
        LOGGER.info("Saludar invocado" + erepo);
        System.out.println(erepo.findAll());
        for (Map.Entry<String, List<String>> x : headers.entrySet()) {
            System.out.println(x.getKey() + " --> " + x.getValue());
        }
        return new Saludo("hola");
    }
}
        