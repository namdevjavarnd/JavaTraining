package com.spring.boot.ems.integration;

import com.spring.boot.ems.controller.HomeController;
import com.spring.boot.ems.controller.UserController;
import com.spring.boot.ems.repository.UserRepository;
import com.spring.boot.ems.service.EnquiryService;
import com.spring.boot.ems.service.UserService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;




@Tag("slow")
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(locations = "/test.properties")
@AutoConfigureMockMvc(secure=false)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class HomeControllerIntegrationTests {

    @Autowired
    private HomeController homeController;

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("HomeController - isNotNull check")
    public void homeControllerTest_0() {
        assertThat(homeController).isNotNull();
    }

    @Test
    @DisplayName("HomeController - returned enqyiryForm.html check")
    public void homeControllerTest_1() throws Exception {
        this.mvc
                .perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("enquiryForm"))
                .andExpect(content().string(containsString("Remove Polygon")))
                .andDo(MockMvcResultHandlers.print());
    }

}
