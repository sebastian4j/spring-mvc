package com.sebastian.hello.controller;
 
import com.sebastian.hello.service.EmpresaService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class HelloWorldController {
    private static final Logger LOGGER = LogManager.getLogger(HelloWorldController.class);
    @Autowired
    private EmpresaService es;
    
    
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response,  Model model) {        
        if (LOGGER.isDebugEnabled()) {            
            LOGGER.debug("controller invocado!!");
        }
        if (es != null)
            LOGGER.info("info mensaje! " + es);
        else
            System.out.println("es null");
        
        model.addAttribute("greeting", "Hello Spring MVC");
        return "helloworld";
    }
 
}