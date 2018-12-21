package com.boot.develop.contorller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.boot.develop.entity.User;
import com.boot.develop.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureMockMvc
public class UserControllerTest {
	
	@Autowired
	UserService  userService;
	
    @Autowired
    protected WebApplicationContext webAppContext;

    private MockMvc mockMvc;
    
    private User userTn;
    
    private String userActionPath="/user";

	
    @Before
    public void init() throws Exception {

        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).dispatchOptions(true).build();

        userTn = new User();
        
        userTn.setAge(14);
        userTn.setPassWord("123456");
        userTn.setUserName("iata-iata-2018");
        
        //MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

       // when(agentService.findAgent(any())).thenReturn(new Agent());
       // when(airlineService.existsAirline(any())).thenReturn(true);
       
    }
    
    @Test
    public void addUserTest() throws Exception {
    	
    	String  userJson=new ObjectMapper().writeValueAsString(userTn);
    	System.out.println("======userJson:"+userJson);
    	String result=mockMvc.perform(post(userActionPath).contentType(MediaType.APPLICATION_JSON)
                .content(userJson)).
    		andExpect(status().isCreated()).
    		andReturn().getResponse().getContentAsString();
    	
    	System.out.println("=====result :"+result);
    	
    }
	
}
