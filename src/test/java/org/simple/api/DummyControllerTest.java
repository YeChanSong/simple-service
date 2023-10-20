package org.simple.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@SpringBootTest(classes = DummyController.class)
public class DummyControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void dummy가_리턴된다() throws Exception {
        String dummy = "dummy";

        mvc.perform(MockMvcRequestBuilders.get("/dummy"))
                .andExpect(status().isOk())
                .andExpect(content().string(dummy));
    }

    @Test
    public void dummyWithParam() throws Exception {
        String name = "dummy";
        int amount = 123;

        mvc.perform(MockMvcRequestBuilders.get("/dummy/param")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));


    }
}
