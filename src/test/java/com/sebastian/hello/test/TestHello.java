package com.sebastian.hello.test;

import com.sebastian.hello.config.AppConfig;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author sebastian
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class TestHello {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void dependenciasTest() {
        Assert.assertNotNull(wac);
        Assert.assertNotNull(mockMvc);
    }

    @Test
    public void testRestOK() throws Exception {
        mockMvc
                .perform(get("/saludar").with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "admin")))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"saludo\":\"hola\"}"));
    }

    @Test
    public void testRestNoAutorizado() throws Exception {
        mockMvc
                .perform(get("/saludar")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "admin2"))
                )
                .andExpect(status().isNonAuthoritativeInformation());
    }

}
