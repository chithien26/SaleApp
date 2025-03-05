package com.lct.SaleApp.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;
    String description;
    String image;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonProperty("name")
    Category parent;

    @JsonIgnore
    @OneToMany(mappedBy = "parent")
    List<Category> listChildren = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    List<Product> listProducts = new ArrayList<>();


}
