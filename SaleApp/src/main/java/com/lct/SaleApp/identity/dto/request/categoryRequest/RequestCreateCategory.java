package com.lct.SaleApp.identity.dto.request.categoryRequest;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestCreateCategory {
    @NotNull(message = "Name not null!")
    String name;
    String description;
    String image;
    String parent;
}
