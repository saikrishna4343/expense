package com.expense.entity;


import com.expense.utils.CommonConstants;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.slf4j.MDC;

import java.io.Serializable;
import java.time.ZonedDateTime;

import static com.expense.utils.CommonConstants.*;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    private String createdBy;
    @CreationTimestamp
    private ZonedDateTime createdDate;
    private String updatedBy;
    @UpdateTimestamp
    private ZonedDateTime updatedDate;

    @PrePersist
    public void onPersist(){
        if(createdBy == null){
            createdBy = getUser();
        }
        updatedBy = createdBy;
    }

    @PreUpdate
    public void onUpdate(){
        updatedBy = getUser();
    }

    public String getUser(){
        return MDC.get(USER) != null ? MDC.get(USER) : APP_NAME;
    }
}
