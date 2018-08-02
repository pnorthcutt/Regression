package com.suprtek.regressiontracker;



import com.suprtek.regressiontracker.dataobjects.Regression;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import static junit.framework.TestCase.assertNotNull;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by pnorthcutt on 7/26/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
@WebAppConfiguration
public class RegressionTrackerControllerTest {
    private MockMvc mockMvc;
    private HttpMessageConverter mappingJackson2HttpMessageConverter;
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }
    @Before public void setup() throws Exception{
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

    }
    @Test
    public void getAllTest() throws Exception{
        mockMvc.perform(get("/regression/getAll")).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
    @Test
    public void getByIDTest() throws Exception{
        mockMvc.perform(get("/regression/getByID/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("punky brewster")));
    }
    @Test
    public void deleteIDTest() throws Exception{
        mockMvc.perform(get("/regression/delete/delete/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.msg", is("success")));
    }
    @Test
    public void addTest() throws Exception{
        Regression item = new Regression();
        String regression = json(new Regression());
        mockMvc.perform(post("/regression/add/1").contentType(contentType)
                .content(regression))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.msg", is("success1")));
    }
    @Test
    public void modifyTest() throws Exception{
        Regression item = new Regression();
        String regression = json(new Regression());
        mockMvc.perform(post("/regression/modify/modify/1").contentType(contentType)
                .content(regression))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.msg", is("success2")));
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

}
