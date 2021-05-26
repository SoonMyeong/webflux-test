package com.example.soon.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductVo {
    private String name;
    private int price;
}
