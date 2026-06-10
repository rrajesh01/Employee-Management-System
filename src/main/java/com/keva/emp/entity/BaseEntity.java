package com.keva.emp.entity;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {

    @Column(name = "utss_created_by")
    private Long createdBy;

    @Column(name = "utss_created_at")
    private LocalDateTime createdAt;

    @Column(name = "utss_updated_by")
    private Long updatedBy;

    @Column(name = "utss_updated_at")
    private LocalDateTime updatedAt;
}
