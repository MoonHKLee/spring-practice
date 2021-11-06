package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponGroupService {

    private final CouponGroupRepository couponGroupRepository;


    public CouponGroup createCouponGroup(CouponGroupCreateRequest body, String code,String issuerId) {
        CouponGroup couponGroupByCode = couponGroupRepository.findCouponGroupByCode(code)
            .orElseThrow(CodeConflictException::new);

        return couponGroupRepository.save(CouponGroup.builder()
            .name(body.getName())
            .amount(body.getAmount())
            .maxCount(body.getMax_count())
            .validFromDt(body.getValid_from_dt())
            .validToDt(body.getValid_to_dt())
            .issuerId(issuerId)
            .status(CouponGroupStatus.CREATED)
            .build());
    }

    public CouponGroup asdCouponGroup(CouponGroupCreateRequest body, String code,String issuerId) {
        CouponGroup couponGroupByCode = couponGroupRepository.findCouponGroupByCode(code)
            .orElseThrow(CodeConflictException::new);
        couponGroupByCode.getStatus()==CouponGroupStatus.CREATED

        return couponGroupRepository.save(CouponGroup.builder()
            .name(body.getName())
            .amount(body.getAmount())
            .maxCount(body.getMax_count())
            .validFromDt(body.getValid_from_dt())
            .validToDt(body.getValid_to_dt())
            .issuerId(issuerId)
            .status(CouponGroupStatus.CREATED)
            .build());
    }
}
