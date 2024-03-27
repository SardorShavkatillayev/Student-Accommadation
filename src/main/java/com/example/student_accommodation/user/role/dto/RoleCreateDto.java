package com.example.student_accommodation.user.role.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleCreateDto {

    @Column(nullable = false)
    private String name;

}
