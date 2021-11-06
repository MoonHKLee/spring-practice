package com.example.demo;

import java.time.LocalDateTime;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CouponGroupCreateRequest {

    @NotEmpty(message = "name값을 입력해주세요")
    @Size(min = 2,max = 50, message = "name의 길이는 (2~50)입니다.")
    private String name;

    @NotEmpty(message = "amount값을 입력해주세요")
    @Min(value = 1,message = "amount는 최소 1이상이어야 합니다.")
    private int amount;

    @NotEmpty(message = "max-count값을 입력해주세요")
    @Min(value = 1,message = "max_count는 최소 1이상이어야 합니다.")
    private int max_count;

    @NotEmpty(message = "valid_from_dt값을 입력해주세요")
    private LocalDateTime valid_from_dt;

    @NotEmpty(message = "valid_to_dt값을 입력해주세요")
    @FutureOrPresent(message = "valid_to_dt값은 현재보다 과거일 수 없습니다.")
    private LocalDateTime valid_to_dt;
}
