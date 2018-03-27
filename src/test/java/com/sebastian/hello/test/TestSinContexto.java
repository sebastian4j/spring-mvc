package com.sebastian.hello.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sebastian.hello.modelo.Saludo;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author sebastian
 */
public class TestSinContexto {

    @Test
    public void templateTest() throws IOException {
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:8080/spring-mvc/saludar";
        rt.getInterceptors().add(
                new BasicAuthorizationInterceptor("admin", "admin"));
        ResponseEntity<String> response1 = rt.getForEntity(url, String.class);
        Saludo response2 = rt.getForObject(url, Saludo.class);
        System.out.println(response1.getBody());
        System.out.println(response2);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response1.getBody());        
        System.out.println(root);
    }
}
