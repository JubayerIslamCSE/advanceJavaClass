package com.example.java56;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @NotNull(message = "ID is required")
    @Min(value = 1, message = "ID must be more than 1")
    @Max(value = 99, message = "ID must be less than 100")
//    @Size(min = 1, max = 100, message = "ID must be between 1-100")
    private int id;

    @NotBlank(message = "Name can't blank")
    private String name;

    @NotEmpty
    private String category;

    @NotNull(message = "Stock is required")
    @PositiveOrZero(message = "Stock can not be negative")
    private int stock;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.1", message = "Price must be more then 0")
    @DecimalMax(value = "999.99", message = "Price must be less then 1000")
    private double price;
}
