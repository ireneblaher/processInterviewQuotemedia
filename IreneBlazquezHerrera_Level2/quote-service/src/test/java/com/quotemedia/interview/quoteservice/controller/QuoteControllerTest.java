package com.quotemedia.interview.quoteservice.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.quotemedia.interview.quoteservice.service.QuoteService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(QuoteController.class)
public class QuoteControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuoteService quoteServiceMock;

    @Test
    public void testGetQuoteBySymbol() throws Exception {
    	
    	mockMvc.perform(get("/getquotebysymbol/FB"))
               .andExpect(status().isOk());	
    	
    }
    
    @Test
    public void testGetSymbolMostUsedByDay() throws Exception {
    	
    	mockMvc.perform(get("/getsymbolmostusedbyday/2020-01-01"))
               .andExpect(status().isOk());	
    	
    }

}
