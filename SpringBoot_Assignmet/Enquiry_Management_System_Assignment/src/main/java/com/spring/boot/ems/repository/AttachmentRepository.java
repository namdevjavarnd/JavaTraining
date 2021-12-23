

package com.spring.boot.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.ems.model.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    Attachment findById(long id);

}
