package com.example.animal.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
  @Column(updatable = false)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @CreatedDate
  private LocalDateTime register_dtm;

  @Column
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @LastModifiedDate
  private LocalDateTime update_dtm;
}