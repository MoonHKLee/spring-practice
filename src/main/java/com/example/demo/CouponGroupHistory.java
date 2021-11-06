package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coupon_group_histories")
public class CouponGroupHistory extends BaseTime {

    @Id() @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, name = "coupon_group_id")
    private Long couponGroupId;

    @Column(nullable = false, length = 50)
    private String userId;

    private String data;
}
