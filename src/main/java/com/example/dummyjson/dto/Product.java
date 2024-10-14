package com.example.dummyjson.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    @NotNull
    @Min(0L)
    @Max(999L)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private Double price;
}
