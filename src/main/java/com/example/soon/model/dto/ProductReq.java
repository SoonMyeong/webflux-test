package com.example.soon.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductReq {
    private String id;
    private String name;
    private String price;
}
