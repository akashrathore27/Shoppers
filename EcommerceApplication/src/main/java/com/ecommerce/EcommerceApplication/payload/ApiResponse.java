package com.ecommerce.EcommerceApplication.payload;

import lombok.Data;

@Data
public class ApiResponse {

    private String message;
    private boolean request;

    public ApiResponse(String message, boolean request) {
        this.message = message;
        this.request = request;
    }
}
