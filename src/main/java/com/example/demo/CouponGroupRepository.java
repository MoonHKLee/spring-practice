package com.example.demo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponGroupRepository extends JpaRepository<CouponGroup,Long> {

    Optional<CouponGroup> findCouponGroupByCode(String code);
}
