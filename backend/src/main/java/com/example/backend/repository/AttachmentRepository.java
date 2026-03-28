package com.example.backend.repository;

import com.example.backend.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachmentRepository 
        extends JpaRepository<Attachment, String> {

    List<Attachment> findByTaskId(String taskId);

}