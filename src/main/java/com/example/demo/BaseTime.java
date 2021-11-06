package com.example.demo;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseTime {
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;
}
