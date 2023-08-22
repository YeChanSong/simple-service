package api;

import org.junit.jupiter.api.Test;
import org.simple.api.DummyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

}
