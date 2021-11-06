package com.example.demo;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="coupon_groups", uniqueConstraints = {
    @UniqueConstraint(
        name = "unq_coupon_groups_on_code",
        columnNames = "code"
    )})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CouponGroup extends BaseTime {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50)
    private String issuerId;

    @Column(nullable = false, length = 50)
    private String code;

    @Column(nullable = false, length = 50)
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private CouponGroupStatus status;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private int maxCount;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int currentCount;

    @Column(nullable = false)
    private LocalDateTime validFromDt;

    @Column(nullable = false)
    private LocalDateTime validToDt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
