package br.com.alura.school.enrollment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = "classpath:schema.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class EnrollmentControllerTest {
    
    private final ObjectMapper jsonMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_add_new_enrollment() throws Exception {
    	NewEnrollmentRequest newEnrollmentRequest = new NewEnrollmentRequest("rihanna");
		
    	 mockMvc.perform(post("/courses/spring-1/enroll")
                 .contentType(MediaType.APPLICATION_JSON)
                 .content(jsonMapper.writeValueAsString(newEnrollmentRequest)))
                 .andExpect(status().isCreated());
    }
}
