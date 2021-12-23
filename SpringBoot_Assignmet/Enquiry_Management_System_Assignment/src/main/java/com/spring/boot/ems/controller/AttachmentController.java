

package com.spring.boot.ems.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.spring.boot.ems.model.Attachment;
import com.spring.boot.ems.service.AttachmentService;
import com.spring.boot.ems.service.EnquiryService;
import com.spring.boot.ems.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Deals with attachments stored in the database and displayed in detailed enquiry view
 */
@Controller
public class AttachmentController {
    private static final Logger logger = LoggerFactory.getLogger(AttachmentController.class);

    @Autowired
    UserService userService;

    @Autowired
    EnquiryService enquiryService;

    @Autowired
    AttachmentService attachmentService;

    @RequestMapping(value = "/attachment/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {

        byte[] fileContent = attachmentService.getById(id).getFile();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(fileContent, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/attachment/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> downloadImage(@RequestParam Long id) throws IOException {

        Attachment attachment = attachmentService.getById(id);
        byte[] fileContent = attachment.getFile();
        String filename = attachment.getName();
        final HttpHeaders headers = new HttpHeaders();

        headers.add("content-disposition", "inline;filename=" + filename);
        headers.setContentDispositionFormData(filename, filename);

//      headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(fileContent, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getPolygonImage(@PathVariable("id") Long id) throws IOException {
        byte[] fileContent = null;
        try {
            fileContent = enquiryService.getById(id).getImage();
            System.out.println("Enquiry no. " + id + ", image size: " + enquiryService.getById(id).getImage().length);
        } catch (NullPointerException e) {
            System.out.println("No saved coverage image");
        }
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(fileContent, headers, HttpStatus.OK);
    }


}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	