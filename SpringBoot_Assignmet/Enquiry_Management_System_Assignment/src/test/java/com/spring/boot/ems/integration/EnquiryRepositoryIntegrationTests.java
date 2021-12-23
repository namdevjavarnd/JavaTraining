package com.spring.boot.ems.integration;

import com.spring.boot.ems.model.Comment;
import com.spring.boot.ems.model.Enquiry;
import com.spring.boot.ems.model.User;
import com.spring.boot.ems.repository.EnquiryRepository;
import com.spring.boot.ems.repository.UserRepository;

import org.hibernate.Hibernate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;


@Tag("slow")
@TestPropertySource(locations = "/test.properties")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EnquiryRepositoryIntegrationTests {

    @Autowired
    EnquiryRepository enquiryRepository;

    @Autowired
    UserRepository userRepository;

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
    public void enquiryTest_2(){
        Enquiry expectedEnquiry = new Enquiry();
        expectedEnquiry.setName("Kris Triggle");
        expectedEnquiry.setEmail("kris.triggle@googlemail.com");
        expectedEnquiry.setIsbn("978887645676");
        expectedEnquiry.setMessage("I am looking for a map of the Stroud parliamentary constituency" +
                " showing the borders of the constituency and showing other areas in grey scale. " +
                "Is this or something similar a product that you could provide?\n" + "\n" +
                "If so please could you let me know the approximate cost. I am ideally looking " +
                "for something in A1 size and will probably need at least two copies\n" + "\n" +
                "Please let me know there is any further information that would be helpful\n" + "\n" +
                "Many thanks in advance\n" + "\n" + "Kris  \n" + " \n");
        expectedEnquiry.setPhone("23456789876");
        expectedEnquiry.setPolygon("[ [42.85872929577766, -80.58923912822434],[43.099856781745004, " +
                "-79.18298912822434],[42.810390341169196, -78.54578209697434],[42.097078046999414, " +
                "-79.42468834697434],[41.26013214943742, -82.30310631572434],[41.54032330999431, " +
                "-83.33582115947434],[42.19482617765736, -83.77527428447434],[42.324922200918174, " +
                "-83.31384850322434],[42.74587958990549, -81.57800865947434] ]");
        expectedEnquiry.setStatus("waiting");
        expectedEnquiry.setType("Customised Mapping");

        Enquiry actualEnquiry = enquiryRepository.findById(5);

        assertEquals(
                expectedEnquiry.getName(), actualEnquiry.getName(), "enquiry name incorrect");
        assertEquals(
                expectedEnquiry.getEmail(), actualEnquiry.getEmail(), "enquiry email incorrect");
        assertEquals(expectedEnquiry.getPhone(), actualEnquiry.getPhone(), "enquiry phone incorrect");
        assertEquals(expectedEnquiry.getMessage(), actualEnquiry.getMessage(), "enquiry message incorrect");
        assertEquals(expectedEnquiry.getIsbn(), actualEnquiry.getIsbn(), "enquiry isbn incorrect");
        assertEquals(expectedEnquiry.getPolygon(), actualEnquiry.getPolygon(), "enquiry polygon incorrect");
        assertEquals(expectedEnquiry.getStatus(), actualEnquiry.getStatus(), "enquiry status incorrect");
        assertEquals(expectedEnquiry.getType(), actualEnquiry.getType(), "enquiry type incorrect");

    }

    @Test
    @DisplayName("EnquiryRepository, fetch collection properties")
    public void enquiryTest_3(){

        Enquiry actualEnquiry1 = enquiryRepository.findById(5);
        Enquiry actualEnquiry2 = enquiryRepository.findById(7);

        assertEquals(0, actualEnquiry1.getComments().size());
        assertEquals(2, actualEnquiry2.getProgressUser().size());
    }

    @Test
    @DisplayName("EnquiryRepository - save enquiries with ManyToMany & ManyToOne")
    @Sql(scripts = "/enquiry_repository_integration_test_4_add_users.sql", executionPhase = BEFORE_TEST_METHOD)
    public void userRepositoryTest4() {

        User user3Sql = userRepository.findByEmail("user3@test.com");
        User user4Sql = userRepository.findByEmail("user4@test.com");

        Enquiry enquiry1 = new Enquiry();
        enquiry1.setName("test customer1");
        enquiry1.setEmail(("cust1@test.com"));
        enquiry1.setType("enquiry 1 type");
        enquiry1.setMessage("customer 1 message");
        enquiry1.addProgressUser(user3Sql);

        Enquiry enquiry2 = new Enquiry();
        enquiry2.setName("test customer2");
        enquiry2.setEmail(("cust2@test.com"));
        enquiry2.setType("enquiry 2 type");
        enquiry2.setMessage("customer 2 message");
        enquiry2.addProgressUser(user4Sql);
        enquiry2.setClosingUser(user3Sql);

        Enquiry enquiry3 = new Enquiry();
        enquiry3.setName("test customer3");
        enquiry3.setEmail(("cust3@test.com"));
        enquiry3.setType("enquiry 3 type");
        enquiry3.setMessage("customer 3 message");
        enquiry3.addProgressUser(user4Sql);
        enquiry3.setClosingUser(user3Sql);


        enquiryRepository.save(enquiry1);
        enquiryRepository.save(enquiry2);
        enquiryRepository.save(enquiry3);

        User user3Found = userRepository.findByEmail("user3@test.com");
        User user4Found = userRepository.findByEmail("user4@test.com");

        System.out.println(enquiry1);
        System.out.println(enquiry2);
        System.out.println(enquiry3);

        assertAll("user collection properties match",
                () -> assertEquals(2, user3Found.getEnquiriesClosed().size(),
                        "user 3 - enquiries closed incorrect number"),
                () -> assertEquals(1, user3Found.getEnquiriesProgress().size(),
                        "user 3 - enquiries assigned incorrect number"),
                () -> assertEquals(2, user4Found.getEnquiriesProgress().size(),
                        "user 4 - enquiries assigned incorrect number"),
                () -> assertEquals(0, user4Found.getEnquiriesClosed().size(),
                        "user 4 - enquiries closed incorrect number"));
    }

}


