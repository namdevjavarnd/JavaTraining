package com.spring.boot.ems.integration;

import com.spring.boot.ems.controller.EnquiryController;
import com.spring.boot.ems.model.Enquiry;
import com.spring.boot.ems.model.User;
import com.spring.boot.ems.repository.EnquiryRepository;
import com.spring.boot.ems.repository.UserRepository;
import com.spring.boot.ems.service.UserService;
import com.spring.boot.ems.util.FormBean;
import com.spring.boot.ems.util.SearchWrapper;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.spring.boot.ems.CustomSecurityMockMvcRequestPostProcessors.demo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@Tag("slow")
@Tag("serverMock")
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(locations = "/test.properties")
@AutoConfigureMockMvc(secure=false)
public class EnquiryListControllerIntegrationTests {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private EnquiryController enquiryListController;

    @Autowired
    private EnquiryRepository enquiryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;  // @/enquiry/search/regular tests

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {

        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @DisplayName("EnquiryListController - isNotNull check")
    @WithMockUser(username = "Demo", password = "111111", roles = "USER")
    public void enquiryListControllerTest_0() {
        assertThat(enquiryListController).isNotNull();
    }

    @Test
    @DisplayName("EnquiryListController - response check")
//    @WithMockUser(username = "Demo", password = "111111", roles = "USER")
    public void enquiryListControllerTest_1() throws Exception {

        mockMvc.perform(post("/enquiry/list")
                .with(csrf()).with(demo()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("EnquiryListController - @/enquiry/list - status and model attributes")
    public void enquiryListControllerTest_2() throws Exception {

        this.mockMvc.perform(get("/enquiry/list").with(demo()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("enquiryList"))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attributeExists("formBean"))
                .andExpect(model().attributeExists("searchWrapper"))
                .andExpect(model().attributeExists("currentUser"))
                .andExpect(model().attributeExists("enquiryListWrapper"))
                .andExpect(model().attributeExists("waiting"))
                .andExpect(model().attributeExists("opened"))
                .andExpect(model().attributeExists("closed"))
                .andExpect(model().attributeExists("openedByUser"))
                .andExpect(model().attributeExists("assignedToUserAndClosed"))
                .andExpect(model().attributeExists("closedByUser"))
                .andExpect(content().string(containsString("kris.triggle@googlemail.com")))
                .andExpect(model().attribute("enquiryListWrapper", Matchers.hasProperty( "enquiryList", Matchers
                        .hasSize(18)))) // 18 pre-loaded enquiries
                .andExpect(model().attribute("enquiryListWrapper", Matchers.hasProperty( "enquiryList", Matchers
                        .hasItem(Matchers.<Enquiry>hasProperty("email",
                                Matchers.equalToIgnoringCase("john@eddowes.co.uk")))))); // enquiry 18
    }

    @Test
    @DisplayName("EnquiryListController - @/enquiry/list -  after changing enquiry status on the enquiry page")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void enquiryListControllerTest_3() throws Exception {
        Enquiry enquiry = enquiryRepository.findById(5L);
        User demo = userRepository.findByEmail("demo@demo.com");

        assertEquals("waiting", enquiry.getStatus(), "enquiry before update status incorrect");
        enquiry.setStatus("closed");
        enquiry.setClosingUser(demo);

        enquiryRepository.save(enquiry);

        this.mockMvc
                .perform(post("/enquiry/list").with(csrf()).with(demo())
                        .flashAttr("enquiry", enquiry)
                        .param("id", "" + enquiry.getId())
                        .param("status", enquiry.getStatus())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("enquiryList"))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attribute("waiting", 5L)) // -1
                .andExpect(model().attribute("opened", 6L)) // no change
                .andExpect(model().attribute("closed", 7L)) // +1
                .andExpect(model().attribute("closedByUser", 7L)) // +1
                .andExpect(model().attribute("openedByUser", 4L)) // no change
                .andExpect(model().attribute("enquiryListWrapper",
                        Matchers.hasProperty( "enquiryList",
                                Matchers.hasSize(18)))); // 18 pre-loaded enquiries, no change
    }

    @Test
    @DisplayName("EnquiryListController - @/enquiry/list/clear - status and list size")
    public void enquiryListControllerTest_4() throws Exception {

        this.mockMvc.perform(get("/enquiry/list/clear").with(demo()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("enquiryList"))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attribute("enquiryListWrapper",
                        Matchers.hasProperty( "enquiryList", Matchers
                        .hasSize(0))));
    }

    @Test
    @DisplayName("EnquiryListController - @/enquiry/list/last100 - status and list size")
    public void enquiryListControllerTest_5() throws Exception {

        this.mockMvc.perform(get("/enquiry/list/last100").with(demo()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("enquiryList"))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attribute("enquiryListWrapper",
                        Matchers.hasProperty( "enquiryList", Matchers
                                .hasSize(18)))); // 18 pre-loaded enquiries
    }

    @Test
    @DisplayName("EnquiryListController - @/enquiry/list/waiting - status and and list size")
    public void enquiryListControllerTest_6() throws Exception {

        this.mockMvc.perform(get("/enquiry/list/waiting").with(demo()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("enquiryList"))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attribute("enquiryListWrapper",
                        Matchers.hasProperty( "enquiryList", Matchers
                                .hasSize(6)))); // 6 enquiries with "waiting" status
    }

    @Test
    @DisplayName("EnquiryListController - @/enquiry/list/progress - status and and list size")
    public void enquiryListControllerTest_7() throws Exception {

        this.mockMvc.perform(get("/enquiry/list/progress").with(demo()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("enquiryList"))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attribute("enquiryListWrapper",
                        Matchers.hasProperty( "enquiryList", Matchers
                                .hasSize(6)))); // 6 enquiries with "progress" status
    }

    @Test
    @DisplayName("EnquiryListController - @/enquiry/list/closed - status and and list size")
    public void enquiryListControllerTest_8() throws Exception {

        this.mockMvc.perform(get("/enquiry/list/closed").with(demo()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("enquiryList"))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attribute("enquiryListWrapper",
                        Matchers.hasProperty( "enquiryList", Matchers
                                .hasSize(6)))); // 6 enquiries with "closed" status
    }

    @Test
    @DisplayName("EnquiryListController - @/enquiry/list/progress/user/assigned - status and and list size")
    public void enquiryListControllerTest_9() throws Exception {

        this.mockMvc.perform(get("/enquiry/list/progress/user/assigned").with(demo()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("enquiryList"))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attribute("enquiryListWrapper",
                        Matchers.hasProperty( "enquiryList", Matchers
                                .hasSize(4)))); // 4 enquiries with "in progress" status and assigned to Demo user
    }

    @Test
    @DisplayName("EnquiryListController - @/enquiry/list/closed/user/assigned - status and and list size")
    public void enquiryListControllerTest_10() throws Exception {

        this.mockMvc.perform(get("/enquiry/list/closed/user/assigned").with(demo()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("enquiryList"))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attribute("enquiryListWrapper",
                        Matchers.hasProperty( "enquiryList", Matchers
                                .hasSize(6)))); // 6 enquiries assigned to Demo user and closed by another
    }

    @Test
    @DisplayName("EnquiryListController - @/enquiry/list/closed/user/closed - status and and list size")
    public void enquiryListControllerTest_11() throws Exception {

        this.mockMvc.perform(get("/enquiry/list/closed/user/closed").with(demo()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("enquiryList"))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attribute("enquiryListWrapper",
                        Matchers.hasProperty( "enquiryList", Matchers
                                .hasSize(6)))); // 6  enquiries assigned to Demo and closed by Demo user
    }

    @Test
    @DisplayName("EnquiryListController - @/enquiry/list/last/custom -   status and and custom list size")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void enquiryListControllerTest_12() throws Exception {

        FormBean formBean = new FormBean();
        formBean.setNumber(14);

        this.mockMvc
                .perform(post("/enquiry/list/last/custom").with(csrf()).with(demo())
                        .flashAttr("formBean", formBean)
                        .param("number", "" + formBean.getNumber())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("enquiryList"))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attribute("enquiryListWrapper",
                        Matchers.hasProperty( "enquiryList", Matchers
                                .hasSize(14)))); // 14  enquiries on the list
    }

    @Test
    @DisplayName("EnquiryListController - @/enquiry/search/id -   lists specified enquiries")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void enquiryListControllerTest_13() throws Exception {

        FormBean formBean = new FormBean();
        formBean.setNumbersAsString("5, 7"); // 2 existng enquiries

        this.mockMvc
                .perform(post("/enquiry/search/id").with(csrf()).with(demo())
                        .flashAttr("formBean", formBean)
                        .param("numbersAsString", formBean.getNumbersAsString())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("enquiryList"))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attribute("enquiryListWrapper",
                        Matchers.hasProperty( "enquiryList", Matchers
                                .hasSize(2)))); // 2 enquiries on the list

        formBean.setNumbersAsString("12-15"); // 4 existng enquiries
        this.mockMvc
                .perform(post("/enquiry/search/id").with(csrf()).with(demo())
                        .flashAttr("formBean", formBean)
                        .param("numbersAsString", formBean.getNumbersAsString())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("enquiryList"))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attribute("enquiryListWrapper",
                        Matchers.hasProperty( "enquiryList", Matchers
                                .hasSize(4)))); // 4 enquiries on the list

        formBean.setNumbersAsString("24-26"); // 0 existng enquiries
        this.mockMvc
                .perform(post("/enquiry/search/id").with(csrf()).with(demo())
                        .flashAttr("formBean", formBean)
                        .param("numbersAsString", formBean.getNumbersAsString())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("enquiryList"))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attribute("enquiryListWrapper",
                        Matchers.hasProperty( "enquiryList", Matchers
                                .hasSize(0)))); // 0 enquiries on the list

        formBean.setNumbersAsString("5,2,4,24-26, 14-16, 56,34, 45-48"); // 6 existng enquiries
        this.mockMvc
                .perform(post("/enquiry/search/id").with(csrf()).with(demo())
                        .flashAttr("formBean", formBean)
                        .param("numbersAsString", formBean.getNumbersAsString())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("enquiryList"))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attribute("enquiryListWrapper",
                        Matchers.hasProperty( "enquiryList", Matchers
                                .hasSize(6)))); // 6 enquiries on the list
    }


}












