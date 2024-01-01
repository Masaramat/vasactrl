package com.vasactrl.models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "branches")
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
    @Id
    private Long id;

    @Column(value = "name")
    @NotBlank(message = "Name cannot be null")
    private String name;

    @Column(value = "location")
    @NotBlank(message = "Location cannot be null")
    private String location;
}
