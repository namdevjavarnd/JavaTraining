package com.spring.boot.ems.integration;

import com.spring.boot.ems.model.Comment;
import com.spring.boot.ems.model.Enquiry;
import com.spring.boot.ems.model.User;
import com.spring.boot.ems.repository.EnquiryRepository;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;



@Tag("medium")
@TestPropertySource(locations = "/test.properties")
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class EnquiryRepositoryLayerTests {

    User user;
    public Enquiry expectedEnquiry;
    public List<Comment> comments;

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    EnquiryRepository enquiryRepository;

    @BeforeEach
    public void init(){
        user = new User();
        user.setName("Test User");
        user.setEmail("test@test.com");
        comments = new ArrayList<>();
        for(int i = 0; i <10; i++){
            Comment comment = new Comment();
            comment.setContent("test comment " + i);
            comments.add(comment);
        }
        expectedEnquiry = new Enquiry();
        expectedEnquiry.setName("Triggle");
        expectedEnquiry.setEmail("triggle@googlemail.com");
        expectedEnquiry.setIsbn("978887645676");
        expectedEnquiry.setMessage("I am looking for a map of the Stroud parliamentary constituency");
        expectedEnquiry.setPhone("0987654321");
        expectedEnquiry.setPolygon("[42.85872929577766, -80.58923912822434]");
        expectedEnquiry.setStatus("test progress");
        expectedEnquiry.setType("Test type");
        expectedEnquiry.addProgressUser(user);
        expectedEnquiry.setComments(comments);
    }

    @AfterEach
    public void tearDown(){
        expectedEnquiry = null;
    }

    @Test
    @DisplayName("EnquiryRepository test - number of enquiries")
    public void enquiryTest_1(){
        int expectedEnquiryNumber = 18;

        List<Enquiry> enquiryList = enquiryRepository.findAll();
        int actualEnquiryNumber = enquiryList.size();

        assertEquals(expectedEnquiryNumber, actualEnquiryNumber, "incorrect number of enquiries");
    }

    @Test
    @DisplayName("EnquiryRepository, fetch basic properties")
    @Sql(scripts = "/enquiry_repository_layer_test_2_remove_expectedEnquiry.sql",
            executionPhase = AFTER_TEST_METHOD) // removing enquiry from DB
    public void enquiryTest_2(){

        testEntityManager.persist(user);
        testEntityManager.persist(expectedEnquiry);
        testEntityManager.flush();

        // finds last added
        Enquiry actualEnquiry = enquiryRepository.findById(enquiryRepository.findAll().size());

        assertAll("save/find basic properties",
            () -> assertEquals(
                expectedEnquiry.getName(), actualEnquiry.getName(),
                    "enquiry name incorrect"),
            () -> assertEquals(
                    expectedEnquiry.getEmail(), actualEnquiry.getEmail(),
                    "enquiry email incorrect"),
            () -> assertEquals(expectedEnquiry.getPhone(), actualEnquiry.getPhone(),
                    "enquiry phone incorrect"),
            () -> assertEquals(expectedEnquiry.getMessage(), actualEnquiry.getMessage(),
                    "enquiry message incorrect"),
            () -> assertEquals(expectedEnquiry.getIsbn(), actualEnquiry.getIsbn(),
                    "enquiry isbn incorrect"),
            () -> assertEquals(expectedEnquiry.getPolygon(), actualEnquiry.getPolygon(),
                    "enquiry polygon incorrect"),
            () -> assertEquals(expectedEnquiry.getStatus(), actualEnquiry.getStatus(),
                    "enquiry status incorrect"),
            () -> assertEquals(expectedEnquiry.getType(), actualEnquiry.getType(),
                    "enquiry type incorrect"));

    }

    @Test
    @DisplayName("EnquiryRepository, save/fetch collection properties")
    @Sql(scripts = "/enquiry_repository_layer_test_3_add_testEnquiry.sql",
            executionPhase = BEFORE_TEST_METHOD)
    public void enquiryTest_3(){

        testEntityManager.persist(user);
        testEntityManager.persist(expectedEnquiry);
        testEntityManager.flush();

        Enquiry enquiryFromSqlFile  = enquiryRepository.findFirstByName("Enquiry Test");

        Enquiry actualEnquiry1 = enquiryRepository.findById(5); // from data.sql
        Enquiry actualEnquiry2 = enquiryRepository.findById(7); // from data.sql
        Enquiry actualEnquiry3 = enquiryRepository.findById(enquiryRepository.findAll().size()); // expectedEnquiry

        System.err.println("Enquiry Repository size: " + enquiryRepository.findAll().size());
        System.out.flush();

        assertAll("save/find collections",
                () -> assertEquals(0, actualEnquiry1.getComments().size()),
                () -> assertEquals(2, actualEnquiry2.getProgressUser().size()),
                () -> assertEquals(1, actualEnquiry3.getProgressUser().size()),
                () -> assertEquals(10, actualEnquiry3.getComments().size()),
                () -> assertEquals("test comment 5", actualEnquiry3.getComments().get(5).getContent()),
                () -> assertEquals("enquiry_test@test.com", enquiryFromSqlFile.getEmail()),
                () -> assertEquals(21, enquiryRepository.findAll().size(),
                        "incorrect enquiryRepository size"));

    }

}


