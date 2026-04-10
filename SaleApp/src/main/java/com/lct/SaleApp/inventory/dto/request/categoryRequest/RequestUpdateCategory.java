package com.lct.SaleApp.inventory.dto.request.categoryRequest;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestUpdateCategory {
    @NotNull(message = "Name not null!")
    String name;
    String description;
    String image;
    String parent;
}
