package com.example.demo;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class User {
    @Id
    @Column(length = 50, nullable = false)
    private String id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int point;

    private LocalDateTime updatedAt;

}
