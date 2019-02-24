package com.euromoby.oauth.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void validForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/register")
                .accept(MediaType.TEXT_HTML)
                .param("firstName", "Donald")
                .param("lastName", "Trump")
                .param("email", "donald@trump.com")
                .param("password", "melania")
                .param("verifyPassword", "melania")
                .param("agree", "on"))
                .andExpect(model().hasNoErrors())
                .andExpect(redirectedUrl("/"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void invalidForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/register")
                .accept(MediaType.TEXT_HTML))
                .andExpect(model().hasErrors())
                .andExpect(status().isOk());
    }

    @Test
    public void passwordsDoNotMatch() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/register")
                .accept(MediaType.TEXT_HTML)
                .param("firstName", "Donald")
                .param("lastName", "Trump")
                .param("email", "donald@trump.com")
                .param("password", "melania")
                .param("verifyPassword", "melania2")
                .param("agree", "on"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("registerForm", "verifyPassword"))
                .andExpect(status().isOk());
    }
}
