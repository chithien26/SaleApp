package com.lct.SaleApp.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@FieldDefaults(level = AccessLevel.PUBLIC)
public abstract class BaseModel {
    LocalDateTime createdDate = LocalDateTime.now();
    LocalDateTime updatedDate = LocalDateTime.now();
    boolean active = true;

    @PreUpdate
    public void update(){
        this.updatedDate = LocalDateTime.now();
    }
}
