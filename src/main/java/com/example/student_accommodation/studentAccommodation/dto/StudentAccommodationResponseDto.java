package com.example.student_accommodation.studentAccommodation.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentAccommodationResponseDto {


    private UUID id;

    private String name;

    private Integer floorNumber;
    private String adres;
}
