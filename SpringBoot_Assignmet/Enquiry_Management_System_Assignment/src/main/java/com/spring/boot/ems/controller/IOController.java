

package com.spring.boot.ems.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.ems.model.Enquiry;
import com.spring.boot.ems.service.EnquiryService;
import com.spring.boot.ems.service.UserService;
import com.spring.boot.ems.util.GenerateEnquiryListPdfFromCode;
import com.spring.boot.ems.util.PdfCreator;


@Controller
public class IOController {
    private static final Logger logger = LoggerFactory.getLogger(IOController.class);

    @Autowired
    UserService userService;

    @Autowired
    EnquiryService enquiryService;

    @Autowired
    PdfCreator pdfCreator;


    @ResponseBody
    @RequestMapping(value = "/enquiry/list100/pdf", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> enquiryReport() throws IOException {

        List<Enquiry> enquiries = enquiryService.getRecent100Sorted();

        ByteArrayInputStream bis = GenerateEnquiryListPdfFromCode.enquiryListReport(enquiries);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bis));

    }

    @ResponseBody
    @RequestMapping(value = "/enquiry/pdf", method = RequestMethod.POST, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> enquiryPdf(@ModelAttribute Enquiry enquiry, Model model, Principal principal, HttpServletResponse response) throws IOException {

        Enquiry enquiryToView = enquiryService.getById(enquiry.getId());
        enquiryService.sortProgressUsers(enquiryToView);
        model.addAttribute("enquiry", enquiryToView);

        ByteArrayInputStream bis = null;
        try {
            Map<String, Enquiry> data = new HashMap<>();
            data.put("enquiry", enquiryToView);
            bis = pdfCreator.createPdf("enquiryPagePdf", data);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=enquiry.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bis));
    }


    @PostMapping("/enquiry/printable")
    public String enquiryPrintable(@ModelAttribute Enquiry enquiry, Model model, Principal principal, HttpServletResponse response) {

        Enquiry enquiryToView = enquiryService.getById(enquiry.getId());
        enquiryService.sortProgressUsers(enquiryToView);
        model.addAttribute("enquiry", enquiryToView);

        return "enquiryPagePrintable";
    }
	
	
	

}
		
	
	





















