package com.ecommerce.minishop.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseAudit {
    @CreatedBy
    @Column(length = 20, name = "creator_id")
    private String creatorId;

    @CreatedDate
    @Column(name = "creator_time")
    private Date creatorTime;

    @LastModifiedBy
    @Column(length = 20, name = "modifier_id")
    private String modifierId;

    @LastModifiedDate
    @Column(name = "modifier_time")
    private Date modifierTime;
}
