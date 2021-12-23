
package com.spring.boot.ems.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.ems.model.Attachment;
import com.spring.boot.ems.repository.AttachmentRepository;

import java.util.List;

@Service
public class AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

    public Attachment getById(long id) {
        return attachmentRepository.findById(id);
    }


    public List<Attachment> getAll(){
        return attachmentRepository.findAll();
    }


}