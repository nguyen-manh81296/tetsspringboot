package com.example.tetsspringboot.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@ToString
public class BaseEntity {
    @CreatedDate
    private LocalDateTime createAt;
    @LastModifiedDate
    private LocalDateTime  updateAt;
    private int status;
}
