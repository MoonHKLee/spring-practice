package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sns/category", consumes = MediaType.APPLICATION_JSON_VALUE)
public class CouponGroupController {

    @PostMapping(path = "/api/coupon-groups/{code}")
    public Envelope createCouponGroup(HttpServletRequest request,
            @RequestBody @Valid CouponGroupCreateRequest body,
            @PathVariable @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{2,50}",
                message = "올바른 code를 입력해주세요") String code) {

        String issuerId = request.getHeader("X-USER-ID");

        Envelope response = Envelope.builder()
            .success(true)
            .response(null)
            .error(null)
            .build();
        return response;
    }
}


